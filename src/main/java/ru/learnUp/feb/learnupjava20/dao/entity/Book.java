package ru.learnUp.feb.learnupjava20.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private Long id;
    private String imageUrl;
    private String name;
    private String description;
    private Long price;
    private Long count;
    private Long field;

}
