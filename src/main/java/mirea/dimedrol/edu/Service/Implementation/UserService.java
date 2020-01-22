package mirea.dimedrol.edu.Service.Implementation;

import lombok.extern.slf4j.Slf4j;
import mirea.dimedrol.edu.Dto.RoleDto;
import mirea.dimedrol.edu.Model.RoleDao;
import mirea.dimedrol.edu.Model.UserDao;
import mirea.dimedrol.edu.Repository.RoleRepository;
import mirea.dimedrol.edu.Repository.UserRepository;
import mirea.dimedrol.edu.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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
    public UserDao register(UserDao user) {
        List<RoleDao> userRoles = new ArrayList<>();
//        for (RoleDao role: user.getRoles()) //null
//        {
//            RoleDao roleUser = roleRepository.findByName(role.getName());
//            userRoles.add(roleUser);
//        }
        userRoles.add(roleRepository.findByName("USER_ROLE"));
        //TODO: if (education >= phd) add role author
        //TODO: configure another roles

//        List<RoleDao> roles = new ArrayList<>();
//        for (RoleDto role: this.roles) {
//            roleRepository.findByName(role.name);
//        }
//        result.setRoles(roles);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userRoles);
        user.setArticles(new ArrayList<>());
        user.setCreated(new Date());
        user.setUpdated(new Date());

        UserDao registeredUser = userRepository.save(user);
        log.info("IN register - user with email {} successfully registered", registeredUser.getEmail());

        return registeredUser;
    }

    @Override
    public List<UserDao> getAll() {
        List<UserDao> result = userRepository.findAll();
        log.info("IN getAll - {} users found", result.size());
        return result;
    }

    @Override
    public UserDao findByUsername(String username)
    {
        UserDao result = userRepository.findByUsername(username);
        if (result == null)
            log.info("IN findByUsername - no user {} found", username);
        else log.info("IN findByUsername - user {} successfully found by username {}", result, username);
        return result;
    }

    @Override
    public UserDao findByEmail(String email)
    {
        UserDao result = userRepository.findByEmail(email);
        if (result == null)
            log.info("IN findByEmail - no user found by email {}", email);
        else log.info("IN findByEmail - user {} successfully found by email {}", result, email);
        return result;
    }

    @Override
    public UserDao findById(Long id)
    {
        UserDao result = userRepository.findById(id).get();
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
