package mirea.dimedrol228.edu.Controllers;

import mirea.dimedrol228.edu.Domain.Hashtag;
import mirea.dimedrol228.edu.Domain.User;
import mirea.dimedrol228.edu.Repositories.HashtagRepository;
import mirea.dimedrol228.edu.Repositories.UserRepository;
import mirea.dimedrol228.edu.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    HashtagRepository hashtagRepository;

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public String admin() {
        return "admin";
    } //TODO: header

    @GetMapping("/manage-users")
    public String manage_users(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "manage-users";
    }

    @GetMapping("/manage-hashtags")
    public String manage_hashtags() {
        return "manage-hashtags";
    }

    @RequestMapping("/manage-hashtags/edit")
    public String manage_hashtags_edit(@RequestParam String hashtag_name,
                                       @RequestParam String hashtag_description,
                                       Model model) {
        Hashtag hashtag = hashtagRepository.findByName(hashtag_name);
        if (hashtag == null) {
            hashtag = new Hashtag();
            hashtag.setName(hashtag_name);
        }
        hashtag.setDescription(hashtag_description);
        hashtagRepository.save(hashtag);
        model.addAttribute("hashtag_saved", true);
        return "redirect:";
    }

    @RequestMapping("/manage-users/ban")
    public String ban(@RequestParam Long user_id) {
        User victim = userService.findById(user_id);
        victim.setAccountNonLocked(false);
        return "/manage-users";
    }
}
