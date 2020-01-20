package mirea.dimedrol.edu.Controllers;

import lombok.extern.slf4j.Slf4j;
import mirea.dimedrol.edu.Dto.HashtagDto;
import mirea.dimedrol.edu.Model.HashtagDao;
import mirea.dimedrol.edu.Service.Implementation.HashtagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping("/cabinet")
@Slf4j
public class CabinetController {

    @Autowired
    HashtagService hashtagService;

    @GetMapping
    public String cabinet() {
        return "cabinet";
    }

    @GetMapping("/hashtag-managment")
    public String hashtag_managment() {
        return "hashtag-managment";
    }

    @PostMapping("/hashtag-managment/edit")
    public String hashtag_edit(HttpServletRequest request) {
        String name = request.getParameter("hashtag__name");
        String description = request.getParameter("hashtag__descr");
        log.info("IN hastag_edit - request parameters: name = {}, description = {}", name, description);
        HashtagDao existing = hashtagService.findByName(name);
        if (existing == null) {
            HashtagDao hashtagDao = new HashtagDto(name, description).toDAO();
            hashtagService.createHashtag(hashtagDao);
        }
        else hashtagService.editHashtag(existing, description);

        return "redirect:";
    }


}
