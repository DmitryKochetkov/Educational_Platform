package mirea.dimedrol228.edu.Controllers;

import lombok.extern.slf4j.Slf4j;
import mirea.dimedrol228.edu.Domain.Article;
import mirea.dimedrol228.edu.Domain.User;
import mirea.dimedrol228.edu.Repositories.RoleRepository;
import mirea.dimedrol228.edu.Services.ArticleService;
import mirea.dimedrol228.edu.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    ArticleService articleService;

    @Transactional
    @RequestMapping
    public String user(Model model,
                       @RequestParam(required = false) Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User principal = (User) authentication.getPrincipal();
        model.addAttribute("principal", principal);
        model.addAttribute("viewed", principal);
        model.addAttribute("is_admin", principal.getAuthorities().contains(roleRepository.findByAuthority("ROLE_ADMIN")));
        if (id != null) {//&& id != principal.getId()
            User viewed = userService.findById(id);
            if (viewed == null)
                return "/error";
            model.addAttribute("viewed", viewed);
            if (viewed.getAuthorities().contains(roleRepository.findByAuthority("ROLE_ADMIN")))
                model.addAttribute("is_admin", true);
        }
        else if (id == null)
            return "redirect:/user?id=" + userService.findByUsername(principal.getUsername()).getId();

        return "user";
    }

    @RequestMapping("/delete-account")
    public String delete_account() {
        userService.delete(userService.findByUsername(userService.findLoggedIn().getUsername()).getId());
        return "redirect:/logout";
    }

    @RequestMapping("/articles")
    public String my_articles(Model model,
                              @RequestParam(required = false, name="id") Long article_id) {
        model.addAttribute("principal", userService.findByUsername(userService.findLoggedIn().getUsername()));
        if (article_id == null)
        return "my-articles";

        Article article = articleService.findById(article_id);
        model.addAttribute("root", articleService.root);
        model.addAttribute("article", article);
        return "article";
    }

    @RequestMapping("/articles/edit")
    public String my_articles_edit() {
        return "editor";
    }

    @RequestMapping("/articles/save")
    public String save_article(@RequestParam String header,
                               @RequestParam(name = "file") String html,
                               @RequestParam(required = false) List<String> hashtags) {
        System.out.println(html);
        Article article = new Article();
        article.setAuthor(userService.findByUsername(userService.findLoggedIn().getUsername()));
        article.setHeader(header);
        article.setHashtags(new ArrayList<>()); //TODO: hashtags json
        articleService.create(article, html);
        return "redirect:/user/articles"; //TODO: fix bug with last article
    }

    @RequestMapping("/subscribe")
    public String subscribe(@RequestParam(name = "author_id") Long author_id) {
        Long user_id = userService.findLoggedIn().getId();
        userService.subscribe(author_id, user_id);
        return "redirect:/user";
    }

    @RequestMapping("/unsubscribe")
    public String unsubscribe(@RequestParam(name = "author_id") Long author_id) {
        Long user_id = userService.findLoggedIn().getId();
        userService.unsubscribe(author_id, user_id);
        return "redirect:/user";
    }
}
