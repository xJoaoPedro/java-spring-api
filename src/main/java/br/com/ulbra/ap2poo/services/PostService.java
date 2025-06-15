package br.com.ulbra.ap2poo.services;

import br.com.ulbra.ap2poo.dtos.posts.requests.PostRequestDTO;
import br.com.ulbra.ap2poo.dtos.posts.responses.PostResponseDTO;
import br.com.ulbra.ap2poo.dtos.posts.responses.PostUserResponseDTO;
import br.com.ulbra.ap2poo.models.Post;
import br.com.ulbra.ap2poo.models.User;
import br.com.ulbra.ap2poo.repository.PostRepository;
import br.com.ulbra.ap2poo.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public Post getPost(Long id) { return this.postRepository.findById(id).orElseThrow(); }

    public Page<PostResponseDTO> getPosts(Pageable pageable) {
        return this.postRepository
                .findAll(pageable)
                .map(item -> new PostResponseDTO(item.getId(), item.getContent(), new PostUserResponseDTO(item.getUser().getName())));
    }

    public Post createPost(PostRequestDTO postRequest) {
        User user = userRepository.findById(postRequest.getUserId()).orElseThrow();
        Post post = new Post();

        post.setContent(postRequest.getContent());
        post.setUser(user);

        return this.postRepository.save(post);
    }

    public void updatePost(Long id, Post postRequest) {
        Post post = this.postRepository.getReferenceById(id);
        post.setContent(postRequest.getContent());

        this.postRepository.save(post);
    }

    public void deletePost(Long id) {
        Post post = this.postRepository.getReferenceById(id);
        this.postRepository.delete(post);
    }
}
