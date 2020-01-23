package mirea.dimedrol228.edu.Services;

import lombok.extern.slf4j.Slf4j;
import mirea.dimedrol228.edu.Domain.Role;
import mirea.dimedrol228.edu.Domain.User;
import mirea.dimedrol228.edu.Repositories.RoleRepository;
import mirea.dimedrol228.edu.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
        //TODO: user.setArticles(new ArrayList<>());
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

    public String findLoggedInUsername() {
        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
        if (userDetails instanceof UserDetails) {
            return ((UserDetails) userDetails).getUsername();
        }
        return null;
    }
}
