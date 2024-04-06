package org.example.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleTestController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
}
