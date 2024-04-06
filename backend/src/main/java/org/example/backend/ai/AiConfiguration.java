package org.example.backend.ai;

import lombok.extern.slf4j.Slf4j;
import org.example.backend.ai.model.AccountAiModel;
import org.example.backend.ai.model.AllPostAiModel;
import org.example.backend.ai.model.PostAiModel;
import org.example.backend.ai.model.PostStatisticAiModel;
import org.example.backend.repository.AccountRepository;
import org.example.backend.repository.PostRepository;
import org.example.backend.repository.PostStatisticRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
@Slf4j
public class AiConfiguration {

    @Bean
    Function<AccountAiModel.Request, AccountAiModel.Response> getAccountFromDb(AccountRepository accountRepository) {
        log.info("Creating post with request function");
        return request ->
        {
            log.info("Geocode search request: {}", request);
            return new AccountAiModel.Response(accountRepository.findById(request.accountId()).get());
        };
    }

    @Bean
    Function<PostAiModel.Request, PostAiModel.Response> getSinglePostFromDb(PostRepository postRepository) {
        log.info("Creating post with request function");
        return request ->
        {
            log.info("Geocode search request: {}", request);
            return new PostAiModel.Response(postRepository.findPostById(request.postId()).get());
        };
    }

    @Bean
    Function<PostAiModel.Request, AllPostAiModel.Response> getAllPostsFromDb(PostRepository postRepository) {
        log.info("Creating post with request function");
        return request ->
        {
            log.info("Geocode search request: {}", request);
            return new AllPostAiModel.Response(postRepository.findAllPosts());
        };
    }


    @Bean
    Function<PostStatisticAiModel.Request, PostStatisticAiModel.Response> getPostStatisticFromDb(PostStatisticRepository postStatisticRepository) {
        log.info("Creating post with request function");
        return request ->
        {
            log.info("Geocode search request: {}", request);
            return new PostStatisticAiModel.Response(postStatisticRepository.findById(request.postStatisticId()).get());
        };
    }


}

