package mirea.dimedrol228.edu.Controllers;

import mirea.dimedrol228.edu.Config.SecurityConfig;
import mirea.dimedrol228.edu.Domain.Article;
import mirea.dimedrol228.edu.Domain.Role;

import mirea.dimedrol228.edu.Domain.User;
import mirea.dimedrol228.edu.Domain.UserEducation;
import mirea.dimedrol228.edu.Repositories.RoleRepository;
import mirea.dimedrol228.edu.Services.ArticleService;
import mirea.dimedrol228.edu.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    UserService userService;

    @Autowired
    ArticleService articleService;

    @Autowired
    RoleRepository roleRepository;

    @RequestMapping
    public String user(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        try {
            User principal = (User) authentication.getPrincipal();
            model.addAttribute("principal", principal);
        } catch (ClassCastException e) {
            model.addAttribute("principal", "");
        }
        return "index";
    }

    @GetMapping("/faq")
    public String faq() {
        return "faq";
    }

    @GetMapping("/feed")
    public String feed(Model model) {
        model.addAttribute("principal", userService.findByUsername(userService.findLoggedIn().getUsername()));
        return "feed";
    }

    @RequestMapping("/article")
    public String article(Model model,
                          @RequestParam Long id) {
        model.addAttribute("principal", userService.findByUsername(userService.findLoggedIn().getUsername()));
        if (id == null)
            return "user-content";

        Article article = articleService.findById(id);
        model.addAttribute("root", articleService.root);
        model.addAttribute("article", article);
        return "article";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/signup/register")
    public String register(@RequestParam String email,
                           @RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String education,
                           @RequestParam String role,
                           Model model) {
        User user = userService.findByEmail(email);
        if (user != null) {
            model.addAttribute("email_exists", true);
        }

        user = userService.findByUsername(username);
        if (user != null) {
            model.addAttribute("username_exists", true);
        }

        user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setUsername(username);
        user.setEnabled(true);
        user.setAccountNonLocked(true);
        user.setAccountNonExpired(true);
        user.setCredentialsNonExpired(true);
        user.setSubscribers(new ArrayList<>());
        user.setSubscribedTo(new ArrayList<>());
        List<Role> roles = new ArrayList<>();
        switch (role) {
            case "author":
                roles.add(roleRepository.findByAuthority("ROLE_USER"));
                roles.add(roleRepository.findByAuthority("ROLE_AUTHOR"));
                break;

            case "tutor":
                roles.add(roleRepository.findByAuthority("ROLE_USER"));
                roles.add(roleRepository.findByAuthority("ROLE_AUTHOR"));
                roles.add(roleRepository.findByAuthority("ROLE_TUTOR"));
                break;

            default:
                roles.add(roleRepository.findByAuthority("ROLE_USER"));
        }
        user.setAuthorities(roles);
        user.setEducation(UserEducation.valueOf(education.toUpperCase()).toString());

        userService.register(user);

        return "redirect:/";
    }

    @GetMapping("/repos/articles/{fileName:.+}")
    public void downloadWebResource(@PathVariable("fileName") String fileName,
                                      HttpServletResponse response) throws IOException {
        String dataDirectory = SecurityConfig.root + "articles/";
        Path file = Paths.get(dataDirectory, fileName);
        if (Files.exists(file))
        {
            response.setContentType("text/html");
//            response.addHeader("Content-Disposition", "attachment; filename="+fileName);
//            return Files.readString(file);
            try
            {

                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}