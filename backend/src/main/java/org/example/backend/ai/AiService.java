package org.example.backend.ai;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AiService {
    private final OpenAiChatClient chatClient;
    public ChatResponse chatWithAi(String message) {
        ChatResponse chatResponse = chatClient.call(new Prompt(message, OpenAiChatOptions.builder()
                .withN(1)
                .withFunctions(Set.of("getAccountFromDb","getSinglePostFromDb", "getPostStatisticFromDb"))
                .build()));
        return chatResponse;
    }

    public List<String> generatePostUsingMyStyle(String message) {
//        String message = """
//                My account id is 1.
//                For this account get all posts.
//                Based on these posts generate new similar one using my writing style.
//                Additionally, get my age from my account and add a sentence with this age on the beginning.
//                What important, this post have to be written in informal way and my target audience is from 18 to 35 years old.
//                """;
        List<String> responses=new ArrayList<>();
        responses.add(chatClient.call(new Prompt(message, OpenAiChatOptions.builder()
                .withN(1)
                .withFunctions(Set.of("getAccountFromDb","getAllPostsFromDb"))
                .build())).getResult().getOutput().getContent());
        responses.add(chatClient.call(new Prompt(message, OpenAiChatOptions.builder()
                .withN(1)
                .withFunctions(Set.of("getAccountFromDb","getAllPostsFromDb"))
                .build())).getResult().getOutput().getContent());
        responses.add(chatClient.call(new Prompt(message, OpenAiChatOptions.builder()
                .withN(1)
                .withFunctions(Set.of("getAccountFromDb","getAllPostsFromDb"))
                .build())).getResult().getOutput().getContent());
        return responses;
    }
}
