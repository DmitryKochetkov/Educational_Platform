package mirea.dimedrol.edu.Service.Implementation;

import lombok.extern.slf4j.Slf4j;
import mirea.dimedrol.edu.Model.ArticleDao;
import mirea.dimedrol.edu.Model.HashtagDao;
import mirea.dimedrol.edu.Model.UserDao;
import mirea.dimedrol.edu.Repository.ArticleRepository;
import mirea.dimedrol.edu.Service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ArticleService implements IArticleService {

    final String root = "/home/dimedrol/EduAppServer/articles";
    ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public void saveFile(MultipartFile file) throws Exception {
        byte[] bytes = file.getBytes();
        Path path = Paths.get(root + file.getOriginalFilename());
        Files.write(path, bytes);
    }

    @Override
    public void saveHTML(String html) {
        try {
            File file = File.createTempFile("article", ".html", new File(root));
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(html);
            bw.close();
            log.info("IN saveHTML - success");
        }
        catch (Exception e)
        {
            log.info("IN saveHTML - error");
        }
    }

    @Override
    public ArticleDao create(ArticleDao article) {



        article.setCreated(new Date());
        article.setUpdated(new Date());
        return article;
    }

    @Override
    public List<ArticleDao> findByAuthor(UserDao author) {
        List<ArticleDao> result = articleRepository.findByAuthor(author);
        if (result == null)
            log.info("IN findByName - no articles found by author {}", author.getEmail());
        else log.info("IN findByName - articles {} successfully found by author {}", result, author);

        return result;
    }

    @Override
    public ArticleDao findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<ArticleDao> getByHashtag(HashtagDao hashtag) {
        return null;
    }
}
