package juyeong.springcrudauth.model;

/**
 * JPA로 DB에 저장하려면 최소 @Entity와 @Id는 필수입니다.
 */
public class Post {
    private int id;
    private String title;

    public Post() {}

    public Post(int id, String title) {
        this.id = id;
        this.title = title;
    }
}
