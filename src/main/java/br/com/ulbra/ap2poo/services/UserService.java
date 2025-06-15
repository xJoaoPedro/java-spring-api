package br.com.ulbra.ap2poo.services;

import br.com.ulbra.ap2poo.dtos.users.responses.UserPostResponseDTO;
import br.com.ulbra.ap2poo.dtos.users.responses.UserResponseDTO;
import br.com.ulbra.ap2poo.models.Post;
import br.com.ulbra.ap2poo.models.User;
import br.com.ulbra.ap2poo.repository.PostRepository;
import br.com.ulbra.ap2poo.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(Long id) { return this.userRepository.findById(id).orElseThrow(); }

    public Page<UserResponseDTO> getUsers(Pageable pageable) {
        return this.userRepository
                .findAll(pageable)
                .map(user -> new UserResponseDTO(
                        user.getName(),
                        user.getPosts().stream().map(post -> new UserPostResponseDTO(post.getContent())).toList())
                ); }

    public User createUser(User user) { return this.userRepository.save(user); }

    public void updateUser(Long id, User userRequest) {
        User user = this.userRepository.getReferenceById(id);
        user.setName(userRequest.getName());

        this.userRepository.save(user);
    }

    public void deleteUser(Long id) {
        User user = this.userRepository.getReferenceById(id);
        this.userRepository.delete(user);
    }
}