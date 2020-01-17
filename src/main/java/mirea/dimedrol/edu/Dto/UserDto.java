package mirea.dimedrol.edu.Dto;

import lombok.Data;
import mirea.dimedrol.edu.Model.RoleDao;
import mirea.dimedrol.edu.Model.UserDao;
import mirea.dimedrol.edu.Model.UserEducation;
import mirea.dimedrol.edu.Model.UserRole;
import mirea.dimedrol.edu.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserDto {
    private Long id;
    private String email;
    private String username;
    private String password;
    private List<RoleDto> roles;
    private UserEducation education;

    @Autowired
    private RoleRepository roleRepository;

    public UserDto() {}

    public UserDto(UserDao user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.username = user.getUsername();
        this.password = user.getPassword();
        roles = new ArrayList<>();
        for (RoleDao role: user.getRoles())
            this.roles.add(new RoleDto(role));
        this.education = user.getEducation();
    }

    public UserDao toDAO() {
        UserDao result = new UserDao();
        result.setEmail(email);
        result.setPassword(password);
        result.setUsername(username);
        //
        result.setEducation(education);

        return result;
    }

}
