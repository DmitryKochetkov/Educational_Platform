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

//    @RequestMapping
//    public String user(Model model) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        User principal = (User)authentication.getPrincipal();
//        model.addAttribute("principal", principal);
//        return "user";
//    }

    @RequestMapping
    public String user(Model model,
                       @RequestParam(required = false) Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User principal = (User) authentication.getPrincipal();
        if (id != null && id != principal.getId()) {
            principal = userService.findById(id);

        }
        model.addAttribute("principal", principal);
        return "user";
    }

    @RequestMapping("/articles")
    public String my_articles() {
        return "my-articles";
    }
}
