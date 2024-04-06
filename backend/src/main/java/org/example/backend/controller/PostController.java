package org.example.backend.controller;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.PostWriteDto;
import org.example.backend.dto.respond.PostReadDto;
import org.example.backend.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
