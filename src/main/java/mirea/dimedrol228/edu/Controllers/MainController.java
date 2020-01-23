package mirea.dimedrol228.edu.Controllers;

import mirea.dimedrol228.edu.Domain.Role;

import mirea.dimedrol228.edu.Domain.User;
import mirea.dimedrol228.edu.Domain.UserEducation;
import mirea.dimedrol228.edu.Repositories.RoleRepository;
import mirea.dimedrol228.edu.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    UserService userService;

    @Autowired
    RoleRepository roleRepository;

    @RequestMapping("/")
    public String index(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        model.addAttribute("principal", principal); //TODO: fix bug
        return "index";
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
                           @RequestParam String role) {
        User user = userService.findByEmail(email);
        if (user != null) {
            //TODO: warning
            return "/error";
        }

        user = userService.findByUsername(username);
        if (user != null) {
            //TODO: warning
            return "/error";
        }

        user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setUsername(username);
        user.setEnabled(true);
        user.setAccountNonLocked(true);
        user.setAccountNonExpired(true);
        user.setCredentialsNonExpired(true);
        List<Role> roles = new ArrayList<>();
        switch (role) {
            case "author":
                roles.add(roleRepository.findByAuthority("ROLE_AUTHOR"));
                break;

            case "tutor":
                roles.add(roleRepository.findByAuthority("ROLE_AUTHOR"));
                roles.add(roleRepository.findByAuthority("ROLE_TUTOR"));
                break;

            default:
                roles.add(roleRepository.findByAuthority("ROLE_USER"));
        }
        user.setAuthorities(roles);
        user.setEducation(UserEducation.valueOf(education.toUpperCase()).toString());

        userService.register(user);

        return "redirect:";
    }
}
