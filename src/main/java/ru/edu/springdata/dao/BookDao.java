package ru.edu.springdata.dao;

import ru.edu.springdata.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookDao {

    List<Book> findAll();

    List<Book> findByCategory(String category);

    List<Book> findByLanguage(String language);

    List<Book> findBooksByLanguageAndCategory(String language, String category);

    void save(Book book);

    void update(Book book);

    void deleteById(long id);
}
