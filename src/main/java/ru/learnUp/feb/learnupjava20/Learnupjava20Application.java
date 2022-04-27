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
import java.util.Optional;

@Slf4j
@SpringBootApplication
@EnableCaching
public class Learnupjava20Application {

    static void updateAsync(PostService service) {

        Post post = service.getPostById(2L);
        post.setTitle("Title new 4");

        for (int i = 0; i < 5; i++) {
            new Thread(() -> service.update(post)).start();
        }

    }

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(Learnupjava20Application.class, args);

        PostService postService = context.getBean(PostService.class);

        updateAsync(postService);
    }

}
