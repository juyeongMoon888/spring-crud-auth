package juyeong.springcrudauth.controller;

import juyeong.springcrudauth.model.Post;
import juyeong.springcrudauth.service.PostQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final PostQueryService postQueryService;

    @Autowired
    public HomeController(PostQueryService postQueryService) {
        this.postQueryService = postQueryService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Post> posts = postQueryService.findPostPage();
        model.addAttribute("posts", posts);
        return "main";
    }
}
