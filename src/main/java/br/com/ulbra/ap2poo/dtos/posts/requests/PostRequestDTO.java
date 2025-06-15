package br.com.ulbra.ap2poo.dtos.posts.requests;

public class PostRequestDTO {
    private String content;
    private Long userId;

    public PostRequestDTO(String content, Long id) {
        this.content = content;
        this.userId = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
