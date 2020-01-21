package mirea.dimedrol.edu.Repository;

import mirea.dimedrol.edu.Model.ArticleDao;
import mirea.dimedrol.edu.Model.UserDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleDao, Long> {
    List<ArticleDao> findByAuthor(UserDao author);
}
