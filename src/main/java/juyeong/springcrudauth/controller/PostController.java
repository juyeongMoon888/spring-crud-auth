package juyeong.springcrudauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {

    @GetMapping("/postForm")
    public String writePostFrom() {
        return "postForm";
    }

    /*@PostMapping("/postWrite")
    public*/
}
