package mirea.dimedrol.edu.Controllers;

import lombok.extern.slf4j.Slf4j;
import mirea.dimedrol.edu.Service.Implementation.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLWriter;
import java.io.File;
import java.io.FileWriter;

@Controller
@Slf4j
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @GetMapping
    public String article() {
        return "article";
    }

    @GetMapping("/edit")
    public String edit() { return "editor"; }

    @PostMapping("/publish")
    public String publish(@RequestParam("file") String html) {
        //TODO: configure article service
        System.out.println(html);
        articleService.saveHTML(html);
//        MultipartFile file = (MultipartFile) html;
//        try {
//            articleService.saveFile(file);
//        }
//        catch (Exception e) {
//            log.error("Cannot save file");
//        }
        return "redirect:";
    }
}
