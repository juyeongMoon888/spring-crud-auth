package juyeong.springcrudauth.service;

import juyeong.springcrudauth.dto.PostSummaryResponse;
import juyeong.springcrudauth.model.Post;
import juyeong.springcrudauth.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostQueryService {

    @Autowired
    private final PostRepository postRepository;

    public PostQueryService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> findPostPage() {

        return null;
    }

    public void write(String post_title, String post_content) {
        Post post = new Post();
        post.setTitle(post_title);
        post.setContent(post_content);

        postRepository.save(post);
    }

    public Optional<Post> getPost(int id) {
        return postRepository.findById(id);
    }


    //TODO 스트림으로 변환하기
    public List<PostSummaryResponse> getPosts() {
        List<Post> posts = postRepository.findAll();
        List<PostSummaryResponse> res = new ArrayList<>();
        for (Post post : posts) {
            res.add(new PostSummaryResponse(post.getTitle(), post.getContent()));
        }
        return res;
    }
}
