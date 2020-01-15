package mirea.dimedrol.edu.Service.Implementation;

import lombok.extern.slf4j.Slf4j;
import mirea.dimedrol.edu.Model.Role;
import mirea.dimedrol.edu.Model.User;
import mirea.dimedrol.edu.Model.UserRoles;
import mirea.dimedrol.edu.Repository.RoleRepository;
import mirea.dimedrol.edu.Repository.UserRepository;
import mirea.dimedrol.edu.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserService implements IUserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(User user) {
        Role roleUser = roleRepository.findByName("ROLE_USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User registeredUser = userRepository.save(user);

        log.info("IN register - user: {} successfully registered", registeredUser);

        return registeredUser;
    }

    @Override
    public List<User> getAll() {
        List<User> result = userRepository.findAll();
        log.info("IN getAll - {} users found", result.size());
        return result;
    }

    @Override
    public User findByUsername(String username)
    {
        User result = userRepository.findByUsername(username);
        if (result == null)
            log.info("IN findByUsername - no user {} found", username);
        else log.info("IN findByUsername - user {} successfully found by username {}", result, username);
        return result;
    }

    @Override
    public User findByEmail(String email)
    {
        User result = userRepository.findByEmail(email);
        if (result == null)
            log.info("IN findByEmail - no user {} found by email {}", result, email);
        else log.info("IN findByEmail - user {} successfully found by email {}", result, email);
        return result;
    }

    @Override
    public User findById(Long id)
    {
        User result = userRepository.findById(id).get();
        if (result == null) {
            log.info("IN findById - no user found by id {}", id);
            return null;
        }

        log.info("IN findById - user {} successfully found by id {}", result, id);
        return result;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
        log.info("IN deleteById - user with id {} successfully deleted", id);
    }
}
