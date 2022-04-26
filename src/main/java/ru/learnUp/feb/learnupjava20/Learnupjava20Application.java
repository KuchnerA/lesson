package ru.learnUp.feb.learnupjava20;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import ru.learnUp.feb.learnupjava20.dao.User;
import ru.learnUp.feb.learnupjava20.dao.comment.CommentService;
import ru.learnUp.feb.learnupjava20.dao.entity.Comment;
import ru.learnUp.feb.learnupjava20.dao.entity.Post;
import ru.learnUp.feb.learnupjava20.dao.post.PostService;
import ru.learnUp.feb.learnupjava20.dao.repository.PostRepository;
import ru.learnUp.feb.learnupjava20.service.user.UserService;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@SpringBootApplication
@EnableCaching
public class Learnupjava20Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(Learnupjava20Application.class, args);

        UserService userService = context.getBean(UserService.class);

        userService.save(User.builder()
                        .name("Ivan 1")
                        .surname("Ivanov 1")
                        .birthDate(LocalDate.of(2000, 12,20))
                        .address("St.Petersburg")
                .build());

        PostService postService = context.getBean(PostService.class);

        Post post = new Post();
        post.setText("New post text");
        post.setTitle("Nuw post title");
        post.setComments(
                List.of(
                new Comment("New comment 1", post),
                new Comment("New comment 2", post),
                new Comment("New comment 3", post)
                )
        );

        postService.createPost(post);

        log.info("Created: {}", post);

    }

}
