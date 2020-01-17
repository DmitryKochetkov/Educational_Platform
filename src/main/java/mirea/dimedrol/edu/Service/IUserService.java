package mirea.dimedrol.edu.Service;

import mirea.dimedrol.edu.Model.UserDao;

import java.util.List;

public interface IUserService {
    UserDao register(UserDao user);
    List<UserDao> getAll();
    UserDao findByUsername(String username);
    UserDao findByEmail(String email);
    UserDao findById(Long id);
    void delete(Long id);
}
