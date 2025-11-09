package juyeong.springcrudauth.dto;

public class PostEditedResponse {
    private String title;
    private String content;
    private boolean updated;

    public PostEditedResponse(String title, String content, boolean updated) {
        this.title = title;
        this.content = content;
        this.updated = updated;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }


}
