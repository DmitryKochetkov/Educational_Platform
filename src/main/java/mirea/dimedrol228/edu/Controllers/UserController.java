package mirea.dimedrol228.edu.Controllers;

import lombok.extern.slf4j.Slf4j;
import mirea.dimedrol228.edu.Domain.User;
import mirea.dimedrol228.edu.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping
    public String user(Model model,
                       @RequestParam(required = false) Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User principal = (User) authentication.getPrincipal();
        model.addAttribute("principal", principal);
        model.addAttribute("viewed", principal);
        if (id != null && id != principal.getId()) {
            User viewed = userService.findById(id);
            if (viewed == null)
                return "/error";
            model.addAttribute("viewed", viewed);
        }
        else if (id == null)
            return "redirect:/user?id=" + userService.findByUsername(principal.getUsername()).getId();

        return "user";
    }

    @RequestMapping("/delete-account")
    public String delete_account() {
        userService.delete(userService.findByUsername(userService.findLoggedIn().getUsername()).getId());
        return "redirect:/logout";
    }

    @RequestMapping("/articles")
    public String my_articles(Model model) {
        model.addAttribute("principal", userService.findLoggedIn());
        return "my-articles";
    }

    @RequestMapping("/articles/edit")
    public String my_articles_edit() {
        return "editor";
    }
}
