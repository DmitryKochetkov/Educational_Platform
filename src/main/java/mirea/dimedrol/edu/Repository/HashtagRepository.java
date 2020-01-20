package mirea.dimedrol.edu.Repository;

import mirea.dimedrol.edu.Model.HashtagDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HashtagRepository extends JpaRepository<HashtagDao, Long> {
    HashtagDao findByName(String name);
}
