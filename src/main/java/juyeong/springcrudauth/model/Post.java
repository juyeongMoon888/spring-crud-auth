package juyeong.springcrudauth.model;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * JPA로 DB에 저장하려면 최소 @Entity와 @Id는 필수입니다.
 */
@Entity
@Table(name = "posts_crud")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;


    private String content;

    @Version
    private Long version;

    public Post() {}

    public Post(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getVersion() {
        return this.version;
    }
}
