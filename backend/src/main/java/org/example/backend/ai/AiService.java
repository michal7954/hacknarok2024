package org.example.backend.ai;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.ChatResponse;
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
    private final String generateMessageMyStyle = """
            >You are Experienced copywriter generate new post based on analysis other posts.
            >Write using my style of writing
                    >Write only in string not in markdown code.
                    >Answer in language of user message not with prefix (>)
            """;

    private final String generateMessageProposingSthNew = """
            >You are Experienced copywriter generate new post based on analysis other posts.
            >Write using completely new style of writing
                    >Write only in string not in markdown code.
                    >Answer in language of user message not with prefix (>)
            """;
    private final OpenAiChatClient chatClient;

    public ChatResponse chatWithAi(String message) {
        ChatResponse chatResponse = chatClient.call(new Prompt(message, OpenAiChatOptions.builder()
                .withN(1)
                .withFunctions(Set.of("getAccountFromDb", "getSinglePostFromDb", "getPostStatisticFromDb"))
                .build()));
        return chatResponse;
    }

    public List<String> generatePostUsingMyStyle(String message) {
        return generate3Posts(generateMessageMyStyle, message);
    }

    public List<String> generatePostProposingSthNew(String message) {
        return generate3Posts(generateMessageProposingSthNew, message);
    }

    private List<String> generate3Posts(String generateMessage, String message) {
        List<String> responses = new ArrayList<>();
        responses.add(chatClient.call(new Prompt(generateMessage + message, OpenAiChatOptions.builder()
                .withN(1)
                .withFunctions(Set.of("getAccountFromDb", "getAllPostsFromDb"))
                .build())).getResult().getOutput().getContent());
        responses.add(chatClient.call(new Prompt(generateMessage + message, OpenAiChatOptions.builder()
                .withN(1)
                .withFunctions(Set.of("getAccountFromDb", "getAllPostsFromDb"))
                .build())).getResult().getOutput().getContent());
        responses.add(chatClient.call(new Prompt(generateMessage + message, OpenAiChatOptions.builder()
                .withN(1)
                .withFunctions(Set.of("getAccountFromDb", "getAllPostsFromDb"))
                .build())).getResult().getOutput().getContent());
        return responses;
    }
}
