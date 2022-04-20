package ru.learnUp.feb.learnupjava20;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.learnUp.feb.learnupjava20.dao.comment.CommentService;
import ru.learnUp.feb.learnupjava20.dao.post.PostService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@SpringBootApplication
public class Learnupjava20Application {

    private static final Logger log = LoggerFactory.getLogger(Learnupjava20Application.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Learnupjava20Application.class, args);

        PostService postService = context.getBean(PostService.class);

        CommentService commentService = context.getBean(CommentService.class);

        log.info("Posts: {}", postService.getPosts());
        log.info("Comment: {}", commentService.getComments());

//        Class.forName("org.postgresql.Driver");
//
//        Connection connection = DriverManager.getConnection("jdbc url");
//        Statement statement = connection.createStatement();
//        statement.execute("");

    }

}
