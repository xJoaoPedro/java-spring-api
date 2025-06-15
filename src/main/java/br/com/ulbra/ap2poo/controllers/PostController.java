package br.com.ulbra.ap2poo.controllers;

import br.com.ulbra.ap2poo.dtos.posts.requests.PostRequestDTO;
import br.com.ulbra.ap2poo.dtos.posts.responses.PostResponseDTO;
import br.com.ulbra.ap2poo.models.Post;
import br.com.ulbra.ap2poo.services.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/posts")
public class PostController {
    private PostService postService;

    public PostController(PostService postService) { this.postService = postService; }

    @GetMapping
    public ResponseEntity<Page<PostResponseDTO>> getPosts(Pageable pageable) { return ResponseEntity.ok(this.postService.getPosts(pageable)); }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPost(@PathVariable Long id) { return ResponseEntity.ok(this.postService.getPost(id)); }

    @PostMapping
    public ResponseEntity<Void> createPost(@RequestBody PostRequestDTO post) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(post.getUserId()).toUri();

        this.postService.createPost(post);
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePost(@PathVariable Long id, @RequestBody Post postRequest) {
        this.postService.updatePost(id, postRequest);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        this.postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }
}
