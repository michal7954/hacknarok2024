package org.example.backend.service;

import lombok.RequiredArgsConstructor;
import org.example.backend.db.Post;
import org.example.backend.dto.mapper.PostMapper;
import org.example.backend.dto.request.PostWriteDto;
import org.example.backend.dto.respond.PostReadDto;
import org.example.backend.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostMapper postMapper;
    private final PostRepository postRepository;

    @Transactional
    public PostReadDto addPost(PostWriteDto postWriteDto) {
        Post post = postMapper.mapPostWriteDtoToPost(postWriteDto);
        Post savedPost = postRepository.save(post);
        return postMapper.mapPostToReadDto(savedPost);
    }
}
