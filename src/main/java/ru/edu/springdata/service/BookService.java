package ru.edu.springdata.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.edu.springdata.entity.Book;
import ru.edu.springdata.repository.BookRepository;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Service
public class BookService {
    @Autowired
    public BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Book saveBook(Book book) {
        return bookRepository.findById(bookRepository.save(book).getId())
                .orElseThrow(() -> new RuntimeException("Book don't saved."));
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> findByCategory(Long category) {
        return bookRepository.findByCategoryId(category);
    }
    public List<Book> findByLanguage(String language) {
        return bookRepository.findByLanguage(language);
    }

    public List<Book> getAllByLanguageAndCategory(String language, String category) {
        return bookRepository.getAllByLanguageAndCategoryName(language, category);
    }
}
