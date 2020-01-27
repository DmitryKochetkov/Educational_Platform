package mirea.dimedrol228.edu.Repositories;

import mirea.dimedrol228.edu.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> { //TODO: Paging and Sorting repository
    User findByUsername(String username);
    User findByEmail(String email);
    List<User> findAll();
}
