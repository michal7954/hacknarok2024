package org.example.backend.controller;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.respond.PostStatisticReadDto;
import org.example.backend.service.PostStatisticService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${api.prefix}/author")
@RequiredArgsConstructor
public class PostStatisticController {

    private final PostStatisticService postStatisticService;

    @GetMapping(path = "/posts/{postId}/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PostStatisticReadDto> getPostStatistics(
            @PathVariable("postId") Long postId) {
        PostStatisticReadDto postStatisticReadDto = postStatisticService.getPostStatisticsByPostId(postId);
        return ResponseEntity.ok(postStatisticReadDto);
    }
}
