package org.example.backend.ai.model;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import org.example.backend.db.PostStatistic;

public interface PostStatisticAiModel {
    @JsonClassDescription("Use it for getting post statistic by postStatisticId. ")
    record Request(Long postStatisticId) {
    }
    record Response(PostStatistic postStatistic) {
    }
}
