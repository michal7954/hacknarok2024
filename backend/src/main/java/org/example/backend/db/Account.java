package org.example.backend.db;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
//    private Integer numberOfPosts;
    private Integer numberOfFollowers;
    @Lob
    @Column(length = 1000)
    private String yourInfo;
    @Lob
    @Column(length = 1000)
    private String followersInfo;
//    private Integer numberOfViews;
//    private Integer numberOfComments;
//    private Integer numberOfShares;

    @OneToMany
    private List<Post> posts;

}
