package org.example.backend.ai;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AiController {
    private final AiService aiService;
    @PostMapping("/ai")
    private ChatResponse chatWithAi(@RequestBody String message) {
        return aiService.chatWithAi(message);
    }

    @PostMapping("/generatePostUsingMyStyle")
    private ChatResponse generatePostUsingMyStyle(){
        return aiService.generatePostUsingMyStyle();
    }
}
