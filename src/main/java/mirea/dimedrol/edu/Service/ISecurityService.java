package mirea.dimedrol.edu.Service;


public interface ISecurityService {
    String findLoggedInUsername();
    void autoLogin(String username, String password);
}
