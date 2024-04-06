package org.example.backend.ai;

import lombok.extern.slf4j.Slf4j;
import org.example.backend.ai.model.PostAiModel;
import org.example.backend.repository.AccountRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
@Slf4j
public class AiConfiguration {

    @Bean
    Function<PostAiModel.Request, PostAiModel.Response> getSinglePostFromDb(AccountRepository accountRepository) {
        log.info("Creating post with request function");

        return request ->
        {
            log.info("Geocode search request: {}", request);
            return new PostAiModel.Response( accountRepository.findById(request.accountId()).get() );
        };
    }


}

