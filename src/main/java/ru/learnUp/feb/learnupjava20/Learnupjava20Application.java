package ru.learnUp.feb.learnupjava20;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.learnUp.feb.learnupjava20.dao.entity.Comment;
import ru.learnUp.feb.learnupjava20.dao.entity.Post;
import ru.learnUp.feb.learnupjava20.dao.post.PostDao;
import ru.learnUp.feb.learnupjava20.service.Calculator;
import ru.learnUp.feb.learnupjava20.service.Operation;
import ru.learnUp.feb.learnupjava20.service.ValueService;

import java.util.List;

@SpringBootApplication
public class Learnupjava20Application {

    private static final Logger log = LoggerFactory.getLogger(Learnupjava20Application.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Learnupjava20Application.class, args);

        Calculator calculator = context.getBean(Calculator.class);
        log.info("{} * {} = {}", 2, 2, calculator.calculate(2, 2, Operation.MULTIPLY));

        context.getBean(ValueService.class).print();

        PostDao postDao = context.getBean(PostDao.class);

        Comment comment =new Comment();
        comment.setText("Comment text");

        Post post = new Post();
        post.setText("Post text");
        post.setTitle("Post title");
        comment.setPost(post);
        post.setComments(List.of(comment));

        postDao.createPost(post);

        List<Post> posts = postDao.getPosts();
        log.info("{}", posts);

    }

}
