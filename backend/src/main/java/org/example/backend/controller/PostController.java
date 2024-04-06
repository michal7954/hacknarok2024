package org.example.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.PostWriteDto;
import org.example.backend.dto.respond.PostReadDto;
import org.example.backend.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "${api.prefix}/author")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping(path = "/posts",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<PostReadDto> addPost(@RequestBody PostWriteDto postWriteDto) {
        PostReadDto postReadDto = postService.addPost(postWriteDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(postReadDto);
    }

    @GetMapping(path = "/posts/{postId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PostReadDto> getPostById(
            @Schema(defaultValue = "1")
            @PathVariable("postId") Long postId) {
        return ResponseEntity.ok(postService.getPostById(postId));
    }

    @GetMapping(path = "/posts", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PostReadDto>> getPosts() {
        return ResponseEntity.ok(postService.getPosts());
    }
}
