package mirea.dimedrol.edu.Service;

import mirea.dimedrol.edu.Model.ArticleDao;
import mirea.dimedrol.edu.Model.HashtagDao;
import mirea.dimedrol.edu.Model.UserDao;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IArticleService {
    ArticleDao create(ArticleDao article);
    List<ArticleDao> findByAuthor(UserDao author);
    ArticleDao findById(Long id);
    void delete(Long id);
    List<ArticleDao> getByHashtag(HashtagDao hashtag);

    void saveFile(MultipartFile file) throws Exception;
    void saveHTML(String html);
}
