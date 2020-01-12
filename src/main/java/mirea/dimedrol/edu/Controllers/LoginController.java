package mirea.dimedrol.edu.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/auth")
public class LoginController {
    @PostMapping
    public String auth(HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("passwd");
        System.out.println(login + " " + password);
        return "Auth OK";
    }

    @PostMapping("/reg")
    public String reg(HttpServletRequest request) {
        return "Reg OK";
    }
}
