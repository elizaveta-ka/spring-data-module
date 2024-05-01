package ru.edu.springdata.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private Long id;
    private String name;
    private String language;
    private String category; // history, it, health etc...

    public Book(String name, String language, String category) {
        this.name = name;
        this.language = language;
        this.category = category;
    }
}
