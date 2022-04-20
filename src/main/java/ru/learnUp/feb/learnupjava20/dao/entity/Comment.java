package ru.learnUp.feb.learnupjava20.dao.entity;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString(exclude = {"post"})
@RequiredArgsConstructor
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String text;

    @ManyToOne
    @JoinColumn
    @Fetch(FetchMode.SELECT)
    private Post post;

}
