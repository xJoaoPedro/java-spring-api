package br.com.ulbra.ap2poo.dtos.posts.responses;

public class PostResponseDTO {
    private Long id;
    private String content;
    private PostUserResponseDTO user;

    public PostResponseDTO(Long id, String content, PostUserResponseDTO user) {
        this.id = id;
        this.user = user;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public PostUserResponseDTO getUser() {
        return user;
    }

    public void setUser(PostUserResponseDTO user) {
        this.user = user;
    }
}
