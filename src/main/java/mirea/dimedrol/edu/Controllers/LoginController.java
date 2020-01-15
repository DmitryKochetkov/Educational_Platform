package mirea.dimedrol.edu.Controllers;

import mirea.dimedrol.edu.Model.User;
import mirea.dimedrol.edu.Model.UserRoles;
import mirea.dimedrol.edu.Repository.UserRepository;
import mirea.dimedrol.edu.Service.Implementation.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping
    public String auth(HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("passwd");
        System.out.println(login + " " + password);

        User temp = userService.findByEmail(login);


        return "Auth OK";
    }

    @PostMapping("/reg")
    public String reg(HttpServletRequest request) {
        String login = request.getParameter("email");
        String password = request.getParameter("passwd");
        String repeat_password = request.getParameter("repeat_passwd");
        String user_role = request.getParameter("role");
        String education = request.getParameter("education");
        String studying = request.getParameter("studying");
        System.out.println("login: " + login);
        System.out.println("password: " + password);
        System.out.println("repeat password: " + repeat_password);
        System.out.println("user_role: " + user_role);
        System.out.println("education: " + education);
        System.out.println("studying: " + studying);
        System.out.println();

        User user = userService.findByUsername(login);

        return "Reg OK";
    }


}
