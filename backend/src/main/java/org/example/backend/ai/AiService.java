package org.example.backend.ai;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AiService {
    private final OpenAiChatClient chatClient;
    public ChatResponse chatWithAi(String message) {
        ChatResponse chatResponse = chatClient.call(new Prompt(message, OpenAiChatOptions.builder()
                .withN(1)
                .withFunctions(Set.of("getSinglePostFromDb"))
                .build()));
        return chatResponse;
    }
}
