package mirea.dimedrol.edu.Controllers;

import mirea.dimedrol.edu.Dto.RoleDto;
import mirea.dimedrol.edu.Dto.UserDto;
import mirea.dimedrol.edu.Model.UserDao;
import mirea.dimedrol.edu.Model.UserEducation;
import mirea.dimedrol.edu.Repository.RoleRepository;
import mirea.dimedrol.edu.Service.Implementation.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    RoleRepository roleRepository;

    @PostMapping
    public String auth(HttpServletRequest request, Map<String, Object> model) {
        String login = request.getParameter("login");
        String password = request.getParameter("passwd");
        System.out.println(login + " " + password);

        UserDao temp = userService.findByEmail(login);
        if (temp == null) {
            //TODO: warning
            return "redirect:";
        }

        return "/cabinet";

    }

    @PostMapping("/reg")
    public String reg(HttpServletRequest request) {
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("passwd");
        String repeat_password = request.getParameter("repeat_passwd");
        String role = request.getParameter("role").toUpperCase();
        String education = request.getParameter("education");
        String studying = request.getParameter("studying");
        System.out.println("login: " + email);
        System.out.println("password: " + password);
        System.out.println("repeat password: " + repeat_password);
        System.out.println("role: " + role);
        System.out.println("education: " + UserEducation.valueOf(education.toUpperCase()));
        System.out.println();

        UserDao user = userService.findByEmail(email);
        if (user != null) {
            //TODO: warning
            return "/error";
        }

        user = userService.findByUsername(username);
        if (user != null) {
            //TODO: warning
            return "/error";
        }

        UserDto userDto = new UserDto();
        userDto.setEmail(email);
        userDto.setPassword(password);
        userDto.setUsername(username);
        List<RoleDto> roles = new ArrayList<>();

        roles.add(new RoleDto(roleRepository.findByName("USER_ROLE"))); //wrong repository
        userDto.setRoles(roles);
        userDto.setEducation(UserEducation.valueOf(education.toUpperCase()));

        userService.register(userDto.toDAO());

        return "redirect:";
    }




}
