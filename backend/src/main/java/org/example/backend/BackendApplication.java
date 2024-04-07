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

            Account account = generatePerson(context);
            personRepository.save(account);

    }

    public static Account generatePerson(ConfigurableApplicationContext context) {
        Account account = new Account();
        account.setYourInfo("\uD83D\uDC4B Hello, I'm John! \uD83D\uDE80\n" +
                "\n" +
                "\uD83D\uDC68\u200D\uD83D\uDCBB Software Engineer | \uD83C\uDF31 Health Enthusiast | \uD83D\uDCDA Lifelong Learner\n" +
                "\n" +
                "\uD83D\uDD0D About Me:\n" +
                "I'm a dedicated software engineer with 5 of experience in Web Development. I'm passionate about leveraging technology to solve complex problems and create innovative solutions that positively impact people's lives.\n" +
                "\n" +
                "\uD83C\uDF31 Health & Diet:\n" +
                "Beyond coding, I have a deep interest in health, nutrition, and personal well-being. I believe that a healthy lifestyle is essential for peak performance, both professionally and personally. I enjoy sharing insights and tips on maintaining a balanced diet, staying active, and cultivating holistic wellness habits.\n" +
                "\n" +
                "\uD83D\uDCA1 Personal Growth:\n" +
                "I'm a firm believer in continuous learning and personal growth. I'm always seeking opportunities to expand my knowledge, develop new skills, and challenge myself to reach new heights. Whether it's through books, courses, or networking with industry professionals, I'm committed to evolving both personally and professionally.\n" +
                "\n" +
                "\uD83D\uDCDD Let's Connect:\n" +
                "If you share my passion for technology, health, or personal growth, I'd love to connect with you! Feel free to reach out, and let's explore how we can inspire and support each other on our respective journeys.");
        account.setFollowerInfo("");
        account.setName("John");
        account.setAge(23);
//        account.setNumberOfPosts(NUMBER_OF_POSTS_PER_ACCOUNT);
        account.setNumberOfFollowers(1300);
//        account.setNumberOfViews(random.nextInt(10000));
//        account.setNumberOfComments(random.nextInt(1000));
//        account.setNumberOfShares(random.nextInt(500));

        List<Post> posts = generatePosts(context);
        account.setPosts(posts);
        return account;
    }


//    public static List<Post> generateRandomPosts(ConfigurableApplicationContext context) {
//        var postRepository = context.getBean(PostRepository.class);
//        List<Post> posts = new ArrayList<>();
//        for (int i = 0; i < NUMBER_OF_POSTS_PER_ACCOUNT; i++) {
//            PostStatistic postStatistic = initPostStatisticsToDatabase(context);
//            Post post = generateRandomPost();
//            post.setPostStatistic(postStatistic);
//            posts.add(postRepository.save(post));
//        }
//        return posts;
//    }

    public static List<Post> generatePosts(ConfigurableApplicationContext context) {
        var postRepository = context.getBean(PostRepository.class);
        var postStatisticRepository = context.getBean(PostStatisticRepository.class);
        List<Post> posts = new ArrayList<>();
        Post post1 = new Post();
        post1.setContent("Yesterday we took part in the competition of students' innovations using IT at AGH University of Science and Technology and our project was awarded by organizers and sponsors of hashtag#ITisMe conference. The project was received as useful in everyday life and with commercial potential. \"RentMe\" is for lending, inventorying and item management. Thank you for this opportunity to participate in such a great festival.");
        post1.setKeywords(Arrays.asList("AGH", "Innovation"));
        post1.setAuthor("John");
        PostStatistic postStatistic1 = new PostStatistic();
        postStatistic1.setNumberOfViews(800);
        postStatistic1.setNumberOfLikes(350);
        postStatistic1.setNumberOfComments(120);
        postStatistic1.setNumberOfShares(60);
        postStatistic1.setEngagementRate(4.0);
        postStatistic1.setNumberOfImpressions(1100);
        postStatistic1.setReach(800);
        postStatistic1.setClickThroughRate(1.8);
        postStatistic1.setConversionRate(0.4);
        postStatistic1.setAverageTimeSpent(32.5);
        post1.setPostStatistic(postStatisticRepository.save(postStatistic1));

        Post post2 = new Post();
        post2.setContent("November 19-20, our team of 6 members took part in a hashtag#HackYeah2022 in Tauron Arena Kraków, we had been working 24 hours on a specific challenge and trying to solve it in the most effective way. We focused on Let's compost IT task. During 24 hours of intensive work, thanks to effective cooperation with Adam Wasylewicz on server-side application, we have done 65 commits, and we created a minimum viable product. Mariusz helped us with quick deployment to deliver applications in proper condition. Karolina made excellent design of our app, whereas frontend developers made client-side application based on created by Karolina design. Great atmosphere and new experience for us.");
        post2.setKeywords(Arrays.asList("HackYeah2022", "Kraków"));
        post2.setAuthor("John");
        PostStatistic postStatistic2 = new PostStatistic();
        postStatistic2.setNumberOfViews(900);
        postStatistic2.setNumberOfLikes(400);
        postStatistic2.setNumberOfComments(150);
        postStatistic2.setNumberOfShares(70);
        postStatistic2.setEngagementRate(4.5);
        postStatistic2.setNumberOfImpressions(1200);
        postStatistic2.setReach(850);
        postStatistic2.setClickThroughRate(2.0);
        postStatistic2.setConversionRate(0.45);
        postStatistic2.setAverageTimeSpent(35.0);
        post2.setPostStatistic(postStatisticRepository.save(postStatistic2));

        Post post3 = new Post();
        post3.setContent("On December 9, 2022, we participate in the St. Barbara's day conference of AHG University of Science and Technology. This is one of the largest scientific event at the AGH, and it was an opportunity to present our scientific work. We were the 3rd place winners in the Computer Science section.");
        post3.setKeywords(Arrays.asList("AGH", "Scientific Event"));
        post3.setAuthor("John");
        PostStatistic postStatistic3 = new PostStatistic();
        postStatistic3.setNumberOfViews((int) (800 * 1.5));
        postStatistic3.setNumberOfLikes((int) (350 * 1.5));
        postStatistic3.setNumberOfComments((int) (120 * 1.5));
        postStatistic3.setNumberOfShares((int) (60 * 1.5));
        postStatistic3.setEngagementRate(4.0 * 1.5);
        postStatistic3.setNumberOfImpressions((int) (1100 * 1.5));
        postStatistic3.setReach((int) (800 * 1.5));
        postStatistic3.setClickThroughRate(1.8 * 1.5);
        postStatistic3.setConversionRate(0.4 * 1.5);
        postStatistic3.setAverageTimeSpent(32.5 * 1.5);
        post3.setPostStatistic(postStatisticRepository.save(postStatistic3));


        Post post4 = new Post();
        post4.setContent("Hey there, fellow corporate warriors! \uD83D\uDCBC\uD83D\uDD25\n" +
                "\n" +
                "Let's talk about something that affects all of us, no matter how busy our schedules get – our health and diet! \uD83E\uDD66\uD83C\uDFCB\uFE0F\u200D♀\uFE0F\n" +
                "\n" +
                "As professionals, we often find ourselves caught up in the demands of our work, leaving little time to focus on our well-being. But let me tell you, taking care of your health is not a luxury, it's an essential investment! \uD83D\uDCAA\uD83D\uDCAF\n" +
                "\n" +
                "A healthy diet can fuel your mind, boost your productivity, and keep you performing at your best in the corporate world. So why not prioritize it, starting today? \uD83C\uDF1F\n" +
                "\n" +
                "Remember, it's all about balance and making smart choices. Incorporating nutritious meals, regular exercise, and self-care into our daily routines can do wonders for our energy levels, mental clarity, and overall happiness. \uD83C\uDF08✨\n" +
                "\n" +
                "Let's inspire and support each other on this journey to a healthier lifestyle. Share your favorite quick and nutritious recipes, fitness tips, or even the challenges you face in prioritizing your well-being. Together, we can create a community that embraces and thrives on health and wellness! \uD83C\uDF31\uD83E\uDD1D\n" +
                "\n" +
                "So what are you waiting for? Join the conversation and let's conquer the corporate world with vibrant energy and a nourished body and mind! \uD83D\uDCA5\uD83D\uDCBC");
        post4.setKeywords(Arrays.asList("healthanddiet ", "corporatewellness ", "prioritizeyourwellbeing ", "mindbodysoul ", "healthychoices"));
        post4.setAuthor("Mati");
        PostStatistic postStatistic4 = new PostStatistic();
        postStatistic4.setNumberOfViews((int) (800 * 1.7));
        postStatistic4.setNumberOfLikes((int) (350 * 1.7));
        postStatistic4.setNumberOfComments((int) (120 * 1.7));
        postStatistic4.setNumberOfShares((int) (60 * 1.7));
        postStatistic4.setEngagementRate(4.0 * 1.7);
        postStatistic4.setNumberOfImpressions((int) (1100 * 1.7));
        postStatistic4.setReach((int) (800 * 1.7));
        postStatistic4.setClickThroughRate(1.8 * 1.7);
        postStatistic4.setConversionRate(0.4 * 1.7);
        postStatistic4.setAverageTimeSpent(32.5 * 1.7);
        post4.setPostStatistic(postStatisticRepository.save(postStatistic4));

        Post post5 = new Post();
        post5.setContent("\uD83C\uDF31 Boost Your Performance at Work with a Healthy Diet \uD83C\uDF31\n" +
                "\n" +
                "Are you feeling drained and lacking the energy to conquer your workday? It's time to supercharge your performance with the power of a healthy diet!\n" +
                "\n" +
                "As professionals in the corporate world, we often find ourselves caught up in the hustle and bustle, neglecting our own health and well-being. But did you know that what you eat can have a significant impact on your productivity and focus?\n" +
                "\n" +
                "Investing in a balanced diet will not only enhance your physical health but also sharpen your mental clarity. Incorporating nutrient-rich foods such as fruits, vegetables, lean proteins, and whole grains can provide the necessary fuel to power through your busiest days.\n" +
                "\n" +
                "Moreover, a healthy diet can help you manage stress more effectively, improve your mood, and boost your immune system, reducing sick days and increasing your overall effectiveness at work.\n" +
                "\n" +
                "So, let's commit to making smart choices when it comes to what we put on our plates. Start small by swapping out that greasy takeout for a delicious homemade meal or opting for a nutritious snack instead of sugary treats.\n" +
                "\n" +
                "Remember, your health is your greatest asset, and by prioritizing it, you'll not only improve your performance at work but also enhance your overall quality of life.\n" +
                "\n" +
                "\uD83E\uDD57 Fuel your success with a healthy diet and watch your productivity soar! \uD83D\uDE80");
        post5.setKeywords(Arrays.asList("HealthyLifestyle  ", "CorporateWellness  ", "HealthyEating  ", "ProductivityBoost "));
        post5.setAuthor("Mati");
        PostStatistic postStatistic5 = new PostStatistic();
        postStatistic5.setNumberOfViews((int) (800 * 1.9));
        postStatistic5.setNumberOfLikes((int) (350 * 1.9));
        postStatistic5.setNumberOfComments((int) (120 * 1.9));
        postStatistic5.setNumberOfShares((int) (60 * 1.9));
        postStatistic5.setEngagementRate(4.0 * 1.9);
        postStatistic5.setNumberOfImpressions((int) (1100 * 1.9));
        postStatistic5.setReach((int) (800 * 1.9));
        postStatistic5.setClickThroughRate(1.8 * 1.9);
        postStatistic5.setConversionRate(0.4 * 1.9);
        postStatistic5.setAverageTimeSpent(32.5 * 1.9);
        post5.setPostStatistic(postStatisticRepository.save(postStatistic5));

        Post post6 = new Post();
        post6.setContent("Hello, fellow professionals! \uD83D\uDCBC\n" +
                "\n" +
                "In today's fast-paced corporate world, our health and well-being often take a backseat. But let's change that together! \uD83D\uDCAA\n" +
                "\n" +
                "Did you know that maintaining a healthy diet can significantly boost your productivity, focus, and overall success? \uD83E\uDD66\uD83C\uDF4E\n" +
                "\n" +
                "It's time to fuel our bodies with nutritious meals and snacks that will keep us energized throughout the day. \uD83C\uDF31 Whether it's packing a homemade lunch or opting for healthy options during business meetings, small changes can make a big difference in our performance.\n" +
                "\n" +
                "Let's prioritize our health and make conscious choices to support our goals and ambitions. \uD83C\uDF1F Remember, a healthy body leads to a healthy mind, and ultimately, a thriving career! \uD83D\uDE4C\n" +
                "\n" +
                "Are you ready to take on the challenge and start incorporating healthier habits into your corporate lifestyle? Share your thoughts and ideas in the comments below! \uD83D\uDC47");
        post6.setKeywords(Arrays.asList("HealthFirst ", "CorporateWellness ", "EnergizeYourDay"));
        post6.setAuthor("Mati");
        PostStatistic postStatistic6 = new PostStatistic();
        postStatistic6.setNumberOfViews((int) (800 * 1.8));
        postStatistic6.setNumberOfLikes((int) (350 * 1.8));
        postStatistic6.setNumberOfComments((int) (120 * 1.8));
        postStatistic6.setNumberOfShares((int) (60 * 1.8));
        postStatistic6.setEngagementRate(4.0 * 1.8);
        postStatistic6.setNumberOfImpressions((int) (1100 * 1.8));
        postStatistic6.setReach((int) (800 * 1.8));
        postStatistic6.setClickThroughRate(1.8 * 1.8);
        postStatistic6.setConversionRate(0.4 * 1.8);
        postStatistic6.setAverageTimeSpent(32.5 * 1.8);
        post6.setPostStatistic(postStatisticRepository.save(postStatistic6));




        posts.add(postRepository.save(post1));
        posts.add(postRepository.save(post2));
        posts.add(postRepository.save(post3));
        posts.add(postRepository.save(post4));
        posts.add(postRepository.save(post5));
        posts.add(postRepository.save(post6));



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

//    public static Post generateRandomPost() {
//        Post post = new Post();
//        post.setContent("Random Content " + random.nextInt(1000));
//        post.setKeywords(Arrays.asList("Keyword " + random.nextInt(20),
//                "Keyword " + random.nextInt(20),
//                "Keyword " + random.nextInt(20)));
//        post.setAuthor("Author");
//        return post;
//    }
}
