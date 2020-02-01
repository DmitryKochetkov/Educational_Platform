package mirea.dimedrol228.edu.Services;

import lombok.extern.slf4j.Slf4j;
import mirea.dimedrol228.edu.Config.SecurityConfig;
import mirea.dimedrol228.edu.Domain.Article;
import mirea.dimedrol228.edu.Repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;

@Service
@Slf4j
public class ArticleService {

    public final String root = SecurityConfig.root;

    @Autowired
    public ArticleRepository articleRepository;

    public Article findById(Long id) {
        Article result = articleRepository.findById(id).orElse(null);
        if (result == null) {
            log.info("IN findById - no article found by id {}", id);
            return null;
        }

        log.info("IN findById - article {} successfully found by id {}", result, id);
        return result;
    }

    public Article create(Article article, String html) {
        try {
            File file = File.createTempFile("article", ".html", new File(root + "articles"));
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(html);
            bw.close();
            article.setContent_path(file.getName());
            article.setCreated(new Date());
            article.setUpdated(new Date());
            articleRepository.save(article);
            log.info("IN create - success");
            return article;
        }
        catch (Exception e)
        {
            log.info("IN create - error");
            return null;
        }
    }
}
