package org.example.backend.ai.model;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import org.example.backend.db.PostStatistic;

public interface PostStatisticAiModel {
    @JsonClassDescription("Use it to retrieve post statistic")
    record Request(Long postStatisticId) {
    }
    record Response(PostStatistic postStatistic) {
    }
}
