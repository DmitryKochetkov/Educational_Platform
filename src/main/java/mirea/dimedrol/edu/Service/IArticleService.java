package mirea.dimedrol.edu.Service;

import mirea.dimedrol.edu.Model.ArticleDao;
import mirea.dimedrol.edu.Model.HashtagDao;

import java.util.List;

public interface IArticleService {
    ArticleDao create(ArticleDao article);
    ArticleDao findByName(String articleName);
    ArticleDao findById(Long id);
    void delete(Long id);
    List<ArticleDao> getByHashtag(HashtagDao hashtag);
}
