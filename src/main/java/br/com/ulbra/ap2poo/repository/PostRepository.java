package br.com.ulbra.ap2poo.repository;

import br.com.ulbra.ap2poo.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
