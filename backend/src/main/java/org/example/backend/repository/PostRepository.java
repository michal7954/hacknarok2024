package org.example.backend.repository;

import org.example.backend.db.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
    @Query("SELECT post FROM Post post " +
            "JOIN FETCH post.postStatistic postStatistic WHERE post.id=:postId")
    Optional<Post> findPostById(@Param("postId") Long postId);

    @Query("SELECT post FROM Post post " +
            "JOIN FETCH post.postStatistic postStatistic")
    List<Post> findAllPosts();
}
