package mirea.dimedrol228.edu.Repositories;

import mirea.dimedrol228.edu.Domain.Hashtag;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HashtagRepository extends JpaRepository<Hashtag, Long> {
    Hashtag findByName(String name);
}
