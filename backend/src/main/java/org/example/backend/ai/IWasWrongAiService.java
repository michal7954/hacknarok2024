package org.example.backend.ai;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor

public class IWasWrongAiService {
    private final String falitureMessages =
            """
                    >Explain why this post is not good use other functions for populate data.
                    >Analise other posts if it is nessesary.
                    >Write only in string not in markdown code.
                    >Answer in language of user message not with prefix (>)
                                        
                    """;
    private final String improvementMessage =
            """
                    >Explain how this post could be better use other functions for populate data.
                    >Analise other posts if it is nessesary.
                    >Write only in string not in markdown code.
                    >Answer in language of user message not with prefix (>)
                                
                    """;
    private final OpenAiChatClient chatClient;

    public ChatResponse whereIHasMadeMistake(String message) {
        ChatResponse chatResponse = chatClient.call(new Prompt(falitureMessages + message, OpenAiChatOptions.builder()
                .withN(1)
                .withFunctions(Set.of("getAccountFromDb", "getSinglePostFromDb", "getPostStatisticFromDb"))
                .build()));
        return chatResponse;
    }

    public ChatResponse whatCanIImproveMyFuturePosts(String message) {
        ChatResponse chatResponse = chatClient.call(new Prompt(improvementMessage + message, OpenAiChatOptions.builder()
                .withN(1)
                .withFunctions(Set.of("getAccountFromDb", "getSinglePostFromDb", "getPostStatisticFromDb"))
                .build()));
        return chatResponse;
    }
}
