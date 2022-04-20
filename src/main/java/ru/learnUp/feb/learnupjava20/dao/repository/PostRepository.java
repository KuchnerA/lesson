package ru.learnUp.feb.learnupjava20.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.learnUp.feb.learnupjava20.dao.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {


}
