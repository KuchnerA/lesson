package ru.learnUp.feb.learnupjava20.dao.entity;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString(exclude = {"post"})
@AllArgsConstructor
@NoArgsConstructor
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String text;

    @ManyToOne
    @JoinColumn
    @Fetch(FetchMode.JOIN)
    private Post post;

    @Version
    private Long version;

    public Comment(Long id, String text, Post post) {
        this.id = id;
        this.text = text;
        this.post = post;
    }
}
