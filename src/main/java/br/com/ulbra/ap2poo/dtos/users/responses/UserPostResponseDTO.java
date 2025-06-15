package br.com.ulbra.ap2poo.dtos.users.responses;

public class UserPostResponseDTO {
    private String content;

    public UserPostResponseDTO(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
