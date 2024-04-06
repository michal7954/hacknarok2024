package org.example.backend;

import org.example.backend.db.Account;
import org.example.backend.db.Post;
import org.example.backend.db.PostStatistic;
import org.example.backend.repository.AccountRepository;
import org.example.backend.repository.PostRepository;
import org.example.backend.repository.PostStatisticRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class BackendApplication {
    private static final Random random = new Random();
    private final static Integer NUMBER_OF_ACCOUNTS = 3;
    private final static Integer NUMBER_OF_POSTS_PER_ACCOUNT = 10;


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BackendApplication.class, args);
        initPersonsToDatabase(context);
    }


    public static void initPersonsToDatabase(ConfigurableApplicationContext context) {
        var personRepository = context.getBean(AccountRepository.class);
        for (int i = 0; i < NUMBER_OF_ACCOUNTS; i++) {
            Account account = generateRandomPerson(context);
            personRepository.save(account);
        }
    }

    public static Account generateRandomPerson(ConfigurableApplicationContext context) {
        Account account = new Account();
        account.setName("Name " + random.nextInt(20));
        account.setAge(random.nextInt(50));
        account.setNumberOfPosts(NUMBER_OF_POSTS_PER_ACCOUNT);
        account.setNumberOfFollowers(random.nextInt(1000));
        account.setNumberOfViews(random.nextInt(10000));
        account.setNumberOfComments(random.nextInt(1000));
        account.setNumberOfShares(random.nextInt(500));

        List<Post> posts = generateRandomPosts(context);
        account.setPosts(posts);
        return account;
    }


    public static List<Post> generateRandomPosts(ConfigurableApplicationContext context) {
        var postRepository = context.getBean(PostRepository.class);
        List<Post> posts = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_POSTS_PER_ACCOUNT; i++) {
            PostStatistic postStatistic = initPostStatisticsToDatabase(context);
            Post post = generateRandomPost();
            post.setPostStatistic(postStatistic);
            posts.add(postRepository.save(post));
        }
        return posts;
    }

    public static PostStatistic initPostStatisticsToDatabase(ConfigurableApplicationContext context) {
        var postStatisticRepository = context.getBean(PostStatisticRepository.class);
        PostStatistic postStatistic = new PostStatistic();
        postStatistic.setNumberOfViews(random.nextInt(1000));
        postStatistic.setNumberOfLikes(random.nextInt(500));
        postStatistic.setNumberOfComments(random.nextInt(200));
        postStatistic.setNumberOfShares(random.nextInt(100));
        postStatistic.setEngagementRate(random.nextDouble() * 100);
        postStatistic.setNumberOfImpressions(random.nextInt(2000));
        postStatistic.setReach(random.nextInt(1500));
        postStatistic.setClickThroughRate(random.nextDouble() * 10);
        postStatistic.setConversionRate(random.nextDouble() * 5);
        postStatistic.setAverageTimeSpent(random.nextDouble() * 60);
        return postStatisticRepository.save(postStatistic);
    }

    public static Post generateRandomPost() {
        Post post = new Post();
        post.setContent("Random Content " + random.nextInt(1000));
        post.setKeywords(Arrays.asList("Keyword " + random.nextInt(20),
                "Keyword " + random.nextInt(20),
                "Keyword " + random.nextInt(20)));
        post.setAuthor("Author " + random.nextInt(20));
        return post;
    }
}
