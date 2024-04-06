package org.example.backend.dto.respond;

public record PostStatisticReadDto(
        Long id,
        Integer numberOfViews,
        Integer numberOfLikes,
        Integer numberOfComments,
        Integer numberOfShares,
        Double engagementRate,
        Integer numberOfImpressions,
        Integer reach,
        Double clickThroughRate,
        Double conversionRate,
        Double averageTimeSpent
) {}
