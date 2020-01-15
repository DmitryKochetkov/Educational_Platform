package mirea.dimedrol.edu.Service;

import mirea.dimedrol.edu.Model.User;

import java.util.List;

public interface IUserService {
    User register(User user);
    List<User> getAll();
    User findByUsername(String username);
    User findByEmail(String email);
    User findById(Long id);
    void delete(Long id);
}
