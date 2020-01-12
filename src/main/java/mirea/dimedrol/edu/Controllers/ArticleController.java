package mirea.dimedrol.edu.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/article")
public class ArticleController {
    @GetMapping
    public String article() {
        return "article";
    }
}
