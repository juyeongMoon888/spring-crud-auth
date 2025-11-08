package juyeong.springcrudauth.dto;

public class PostEditedResponse {
    private String title;
    private String content;

    public PostEditedResponse(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
