package ru.learnUp.feb.learnupjava20.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentView {

    private Long id;

    private String text;

}
