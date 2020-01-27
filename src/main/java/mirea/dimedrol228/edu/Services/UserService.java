package mirea.dimedrol228.edu.Services;

import lombok.extern.slf4j.Slf4j;
import mirea.dimedrol228.edu.Domain.User;
import mirea.dimedrol228.edu.Repositories.RoleRepository;
import mirea.dimedrol228.edu.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.*;

@Service
@Slf4j
public class UserService implements UserDetailsService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User findByUsername(String username)
    {
        User result = userRepository.findByUsername(username);
        if (result == null)
            log.info("IN findByUsername - no user {} found", username);
        else log.info("IN findByUsername - user {} successfully found by username {}", result, username);
        return result;
    }

    public User findByEmail(String email)
    {
        User result = userRepository.findByEmail(email);
        if (result == null)
            log.info("IN findByEmail - no user found by email {}", email);
        else log.info("IN findByEmail - user {} successfully found by email {}", result, email);
        return result;
    }

    public User findById(Long id)
    {
        User result = userRepository.findById(id).orElse(null);
        if (result == null) {
            log.info("IN findById - no user found by id {}", id);
            return null;
        }

        log.info("IN findById - user {} successfully found by id {}", result, id);
        return result;
    }

    public void delete(Long id) { //TODO: remove from here nahui
        userRepository.deleteById(id);
        log.info("IN deleteById - user with id {} successfully deleted", id);
    }

    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setArticles(new ArrayList<>());
        user.setCreated(new Date());
        user.setUpdated(new Date());

        User registeredUser = userRepository.save(user);
        log.info("IN register - user with email {} successfully registered", registeredUser.getEmail());

        return registeredUser;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username); //TODO: username and email
        if (user != null)
        return user;
        else {
            String msg = "User " + username + " is not registered!";
            throw new UsernameNotFoundException(msg);
        }
    }

    public User findLoggedIn() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user;
    }

    public void subscribe(Long author_id, Long user_id) {
        User author = findById(author_id);
        User user = findById(user_id);
        author.getSubscribers().add(user);
        user.getSubscribedTo().add(author);
        userRepository.save(author);
        userRepository.save(user);
    }

    public void unsubscribe(Long author_id, Long user_id) {
        User author = findById(author_id);
        User user = findById(user_id);
        author.getSubscribers().remove(user);
        user.getSubscribedTo().remove(author);
        userRepository.save(author);
    }
}
