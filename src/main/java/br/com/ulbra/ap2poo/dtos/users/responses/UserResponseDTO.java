package br.com.ulbra.ap2poo.dtos.users.responses;

import java.util.List;

public class UserResponseDTO {
    private String name;
    private List<UserPostResponseDTO> posts;

    public UserResponseDTO(String name, List<UserPostResponseDTO> posts) {
        this.name = name;
        this.posts = posts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserPostResponseDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<UserPostResponseDTO> posts) {
        this.posts = posts;
    }
}
