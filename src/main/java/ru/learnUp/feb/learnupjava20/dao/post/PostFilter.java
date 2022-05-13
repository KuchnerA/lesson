package ru.learnUp.feb.learnupjava20.dao.post;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostFilter {

    private final String text;
    private final String title;

}
