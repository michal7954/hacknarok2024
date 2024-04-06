package org.example.backend.dto.respond;

public record PostAndStatsReadDto(Long id, String content, PostStatisticReadDto postStatisticReadDto) {
}
