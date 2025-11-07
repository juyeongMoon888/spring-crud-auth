package juyeong.springcrudauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostController {

    @GetMapping("/postForm")
    public String showPostFrom() {
        return "postForm";
    }

    @PostMapping("/postWrite")
    public String writePost(@RequestBody String title, String content) {
        return "postWrite";
    }
}
