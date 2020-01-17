package mirea.dimedrol.edu.Repository;

import mirea.dimedrol.edu.Model.UserDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDao, Long> {
    UserDao findByUsername(String name);
    UserDao findByEmail(String email);
}
