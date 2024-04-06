package org.example.backend.db;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostStatistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numberOfViews;
    private Integer numberOfLikes;
    private Integer numberOfComments;
    private Integer numberOfShares;
    private Double engagementRate;
    private Integer numberOfImpressions;
    private Integer reach;
    private Double clickThroughRate;
    private Double conversionRate;
    private Double averageTimeSpent;
}
