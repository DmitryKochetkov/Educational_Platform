package mirea.dimedrol228.edu.Controllers;

import mirea.dimedrol228.edu.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public String user(Model model) {
        model.addAttribute("current_user", userService.findLoggedInUsername()); //TODO: fix bug
        return "user";
    }
}
