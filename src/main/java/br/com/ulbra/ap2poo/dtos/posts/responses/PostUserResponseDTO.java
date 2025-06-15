package br.com.ulbra.ap2poo.dtos.posts.responses;

public class PostUserResponseDTO {
    private String name;

    public PostUserResponseDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
