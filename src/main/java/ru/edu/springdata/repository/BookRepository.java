package ru.edu.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.edu.springdata.entity.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByCategoryId(Long category);

    List<Book> findByLanguage(String language);

    List<Book> getAllByLanguageAndCategoryName(String language, String category);
}
