package ru.learnUp.feb.learnupjava20.dao.post;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.OptimisticLock;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.learnUp.feb.learnupjava20.dao.entity.Post;
import ru.learnUp.feb.learnupjava20.dao.repository.PostRepository;

import javax.persistence.LockModeType;
import javax.persistence.OptimisticLockException;
import java.util.List;

import static org.springframework.data.jpa.domain.Specification.where;
import static ru.learnUp.feb.learnupjava20.dao.repository.PostSpecification.byFilter;

@Slf4j
@Service
public class PostService {

    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Post createPost(Post post) {
        return repository.save(post);
    }

    public List<Post> getPosts() {
        return repository.findAll();
    }

    public List<Post> getPostsBy(PostFilter filter) {
        Specification<Post> specification = where(byFilter(filter));
        return repository.findAll(specification);
    }

    @Cacheable(value = "post")
    public Post getPostById(Long id) {
        return repository.findId1(id);
    }

    @Transactional
    @CacheEvict(value = "post", key = "#post.id")
    @Lock(value = LockModeType.READ)
    public Post update(Post post){
        try {
            return repository.save(post);
        } catch (OptimisticLockException e) {
            log.warn("Optimistic lock exception for post {}", post.getId());
            throw e;
        }
    }

    public Boolean delete(Long id) {
        repository.delete(repository.getById(id));
        return true;
    }

}
