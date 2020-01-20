package mirea.dimedrol.edu.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/article")
public class ArticleController {
    @GetMapping
    public String article() {
        return "article";
    }

    @GetMapping("/edit")
    public String edit() { return "editor"; }

    @PostMapping("/publish")
    public String publish() {
        //TODO: configure article service
        return "redirect:";
    }
}
