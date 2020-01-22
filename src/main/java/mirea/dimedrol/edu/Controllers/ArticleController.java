package mirea.dimedrol.edu.Controllers;

import lombok.extern.slf4j.Slf4j;
import mirea.dimedrol.edu.Model.ArticleDao;
import mirea.dimedrol.edu.Service.Implementation.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

@Controller
@Slf4j
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @GetMapping
    public String article(Model model, @RequestParam(value="id", required = true) Long id) {
        ArticleDao article = articleService.findById(id);
        model.addAttribute("page", articleService.root + article.getContent_path());
        return "article";

    }

    @GetMapping("/edit")
    public String edit() { return "editor"; }

    @PostMapping("/publish")
    public String publish(@RequestParam("header") String header, @RequestParam("file") String html) {
        //TODO: configure article service
        System.out.println(html);
        ArticleDao articleDao = new ArticleDao();
        articleDao.setHeader(header);
        articleService.create(articleDao, html);

        return "/article";
    }
}
