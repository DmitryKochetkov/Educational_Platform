package mirea.dimedrol.edu.Controllers;

import mirea.dimedrol.edu.Dto.HashtagDto;
import mirea.dimedrol.edu.Model.HashtagDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/hashtags")
public class HashtagController {
    @GetMapping
    public List<HashtagDto> getFirstTen() {
        List<HashtagDto> list = new ArrayList<>();
        return list;
    }
}
