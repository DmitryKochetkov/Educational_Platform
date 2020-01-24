package mirea.dimedrol228.edu.Repositories;

import mirea.dimedrol228.edu.Domain.Article;
import mirea.dimedrol228.edu.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByAuthor(User author);
}
