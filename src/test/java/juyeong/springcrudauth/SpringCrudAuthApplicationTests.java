package juyeong.springcrudauth;

import juyeong.springcrudauth.dto.PostCreateRequest;
import juyeong.springcrudauth.dto.PostSummaryResponse;
import juyeong.springcrudauth.model.Post;
import juyeong.springcrudauth.service.PostQueryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpringCrudAuthApplicationTests {

    @Autowired
    private PostQueryService postQueryService;

    @Test
    void 게시글_등록() throws Exception {
        PostCreateRequest dto = new PostCreateRequest();
        dto.setTitle("f5원 공지사항");
        dto.setContent("열심히 공부한다.");

        postQueryService.write(dto.getTitle(), dto.getContent());
        assertThat(dto.getTitle()).isEqualTo("f5원 공지사항");
    }

    @Test
    void 게시글_단일_조회() throws Exception {
        PostCreateRequest dto = new PostCreateRequest();
        dto.setTitle("공지사항");
        dto.setContent("배고프다");

        postQueryService.write(dto.getTitle(), dto.getContent());

        Optional<Post> savedPost = postQueryService.getPost(1);
        assertThat(savedPost).isPresent();
        Post post = savedPost.get();
        assertThat(post.getTitle()).isEqualTo("공지사항");
        assertThat(post.getContent()).isEqualTo("배고프다");
    }

    @Test
    void 게시글_리스트_조회() throws Exception {
        PostCreateRequest dto3 = new PostCreateRequest();
        dto3.setTitle("공지사항-3");
        dto3.setContent("냠냠");
        postQueryService.write(dto3.getTitle(), dto3.getContent());

        PostCreateRequest dto4 = new PostCreateRequest();
        dto4.setTitle("공지사항-4");
        dto4.setContent("으아아아");
        postQueryService.write(dto4.getTitle(), dto4.getContent());

        List<PostSummaryResponse> savedPosts = postQueryService.getPosts();
        assertThat(savedPosts).isNotEmpty();
        /**
         * 아래와 같이 참조값으로 비교하면 findAll()은 DB와 JPA 설정에 따라 반환 순서가 고정적이지 않다.
         * 따라서 필드값으로 비교하는게 좋다.
         */

        /*assertThat(savedPosts.get(0)).isEqualTo(dto3);
        assertThat(savedPosts.get(1)).isEqualTo(dto4);*/

        /**
         * 객체 안의 필드를 테스트한다.
         * extracting() <- 대상 필드
         * contains() <- 포함하는가? 순서 X
         */
        assertThat(savedPosts)
                .extracting("title")
                .contains("공지사항-3", "공지사항-4");
    }
}
