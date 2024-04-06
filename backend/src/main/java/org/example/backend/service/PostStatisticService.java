package org.example.backend.service;

import lombok.RequiredArgsConstructor;
import org.example.backend.db.Post;
import org.example.backend.db.PostStatistic;
import org.example.backend.dto.mapper.PostStatisticMapper;
import org.example.backend.dto.respond.PostStatisticReadDto;
import org.example.backend.exception.custom.notfound.PostNotFound;
import org.example.backend.repository.PostRepository;
import org.example.backend.repository.PostStatisticRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostStatisticService {
    private final PostStatisticMapper postStatisticMapper;
    private final PostStatisticRepository postStatisticRepository;
    private final PostRepository postRepository;

    public PostStatisticReadDto getPostStatisticsByPostId(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new PostNotFound("Post not found"));
        PostStatistic postStatistic = post.getPostStatistic();
        return postStatisticMapper.mapPostStatisticToPostStatisticReadDto(postStatistic);
    }
}
