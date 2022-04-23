package ru.learnUp.feb.learnupjava20;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import ru.learnUp.feb.learnupjava20.dao.comment.CommentService;
import ru.learnUp.feb.learnupjava20.dao.post.PostService;
import ru.learnUp.feb.learnupjava20.dao.repository.PostRepository;

@SpringBootApplication
@EnableCaching
//@EnableRedisRepositories
public class Learnupjava20Application {

    private static final Logger log = LoggerFactory.getLogger(Learnupjava20Application.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Learnupjava20Application.class, args);

        PostService postService = context.getBean(PostService.class);

        CommentService commentService = context.getBean(CommentService.class);

        log.info("Posts: {}", postService.getPosts());
        log.info("Comment: {}", commentService.getComments());

        PostRepository postRepository = context.getBean(PostRepository.class);

        //log.info("Search result: {}", postRepository.findAllByTextContains("asd"));

        //log.info("Search result: {}", postRepository.findByIdWithComments());

        //log.info("Post 1 have {} comments", postRepository.getCommentsCount(1));

        //log.info("Post id = 1: {}", postRepository.findId1(1L));

        for (int i = 0; i < 5; i++) {
            log.info("Post id = 1: {}", postService.getPostById(1L));
        }

    }

}
