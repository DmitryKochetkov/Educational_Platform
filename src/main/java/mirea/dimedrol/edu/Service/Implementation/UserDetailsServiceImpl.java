package mirea.dimedrol.edu.Service.Implementation;

import mirea.dimedrol.edu.Model.RoleDao;
import mirea.dimedrol.edu.Model.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDao user = userService.findByUsername(username);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        for (RoleDao roleDao: user.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(roleDao.getName()));
        }

        return new User(user.getEmail(), user.getPassword(), grantedAuthorities);
    }
}
