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
    private final static Integer NUMBER_OF_ACCOUNTS = 1;
    private final static Integer NUMBER_OF_POSTS_PER_ACCOUNT = 3;


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
        account.setYourInfo("");
        account.setFollowerInfo("");
//        account.setNumberOfPosts(NUMBER_OF_POSTS_PER_ACCOUNT);
        account.setNumberOfFollowers(random.nextInt(1000));
//        account.setNumberOfViews(random.nextInt(10000));
//        account.setNumberOfComments(random.nextInt(1000));
//        account.setNumberOfShares(random.nextInt(500));

        List<Post> posts = generatePosts(context);
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

    public static List<Post> generatePosts(ConfigurableApplicationContext context) {
        var postRepository = context.getBean(PostRepository.class);
        List<Post> posts = new ArrayList<>();
        Post post1 = new Post();
        post1.setContent("Yesterday we took part in the competition of students' innovations using IT at AGH University of Science and Technology and our project was awarded by organizers and sponsors of hashtag#ITisMe conference. The project was received as useful in everyday life and with commercial potential. \"RentMe\" is for lending, inventorying and item management. Thank you for this opportunity to participate in such a great festival.");
        post1.setKeywords(Arrays.asList("Keyword " + random.nextInt(20),
                "Keyword " + random.nextInt(20),
                "Keyword " + random.nextInt(20)));
        post1.setAuthor("Author");
        post1.setPostStatistic(initPostStatisticsToDatabase(context));

        Post post2 = new Post();
        post2.setContent("November 19-20, our team of 6 members took part in a hashtag#HackYeah2022 in Tauron Arena Kraków, we had been working 24 hours on a specific challenge and trying to solve it in the most effective way. We focused on Let's compost IT task. During 24 hours of intensive work, thanks to effective cooperation with Adam Wasylewicz on server-side application, we have done 65 commits, and we created a minimum viable product. Mariusz helped us with quick deployment to deliver applications in proper condition. Karolina made excellent design of our app, whereas frontend developers made client-side application based on created by Karolina design. Great atmosphere and new experience for us.");
        post2.setKeywords(Arrays.asList("Keyword " + random.nextInt(20),
                "Keyword " + random.nextInt(20),
                "Keyword " + random.nextInt(20)));
        post2.setAuthor("Author");
        post2.setPostStatistic(initPostStatisticsToDatabase(context));
        Post post3 = new Post();
        post3.setContent("On December 9, 2022, we participate in the St. Barbara's day conference of AHG University of Science and Technology. This is one of the largest scientific event at the AGH, and it was an opportunity to present our scientific work. We were the 3rd place winners in the Computer Science section.");
        post3.setKeywords(Arrays.asList("Keyword " + random.nextInt(20),
                "Keyword " + random.nextInt(20),
                "Keyword " + random.nextInt(20)));
        post3.setAuthor("Author");
        post3.setPostStatistic(initPostStatisticsToDatabase(context));
        posts.add(postRepository.save(post1));
        posts.add(postRepository.save(post2));
        posts.add(postRepository.save(post3));

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
        post.setAuthor("Author");
        return post;
    }
}
