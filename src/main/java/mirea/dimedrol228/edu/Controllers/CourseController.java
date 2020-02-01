package mirea.dimedrol228.edu.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/course")
public class CourseController {
    @GetMapping
    public String course(@RequestParam Long id) {

        return "course-preview";
    }
}