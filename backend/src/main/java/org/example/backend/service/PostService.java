package org.example.backend.service;

import lombok.RequiredArgsConstructor;
import org.example.backend.db.Post;
import org.example.backend.db.PostStatistic;
import org.example.backend.dto.mapper.PostMapper;
import org.example.backend.dto.request.PostWriteDto;
import org.example.backend.dto.respond.PostAndStatsReadDto;
import org.example.backend.dto.respond.PostReadDto;
import org.example.backend.dto.respond.PostStatisticReadDto;
import org.example.backend.exception.custom.notfound.PostNotFound;
import org.example.backend.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostMapper postMapper;
    private final PostRepository postRepository;

    @Transactional
    public PostReadDto addPost(PostWriteDto postWriteDto) {
        Post post = postMapper.mapPostWriteDtoToPost(postWriteDto);
        post.setAuthor("Author");
        Post savedPost = postRepository.save(post);
        return postMapper.mapPostToReadDto(savedPost);
    }

    public PostAndStatsReadDto getPostById(Long postId) {
        Post post = postRepository.findPostById(postId).orElseThrow(() -> new PostNotFound("Post not found"));
        PostStatistic postStatistic = post.getPostStatistic();
        return postMapper.mapToPostAndStatsReadDto(post, postStatistic);
    }

    public List<PostAndStatsReadDto> getPosts() {
        List<PostAndStatsReadDto> postReadDtos = new ArrayList<>();
        System.out.println(postRepository.findAll());
        for (Post post : postRepository.findAll()) {
            postReadDtos.add(postMapper.mapToPostAndStatsReadDto(post, post.getPostStatistic()==null?
         new PostStatistic(
                    0L,
                    0,
                    0,
                    0,
                    0,
                    0D,
                    0,
                    0,
                    0D,
                    0D,
                    0D
            ):post.getPostStatistic() ));
        }



        return postReadDtos;
    }
}
