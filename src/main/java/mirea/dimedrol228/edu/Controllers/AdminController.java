package mirea.dimedrol228.edu.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping
    public String admin() {
        return "admin";
    }

    @GetMapping("/manage-hashtags")
    public String manage_hashtags() {
        return "manage-hashtags";
    }

    @GetMapping("/manage-hashtags/edit")
    public String manage_hashtags_edit(@RequestParam String hashtag_name, @RequestParam String hashtag_description) {
        //TODO: hashtag logic
        return "redirect:"; //??
    }
}
