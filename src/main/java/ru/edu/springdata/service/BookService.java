package ru.edu.springdata.service;

import org.springframework.stereotype.Service;
import ru.edu.springdata.dao.BookDao;
import ru.edu.springdata.model.Book;

import java.util.List;

@Service
public class BookService {
    public BookDao bookDao;

    public List<Book> getAllBooks() {
        return bookDao.findAll();
    }

    public List<Book> findByCategory(String category) {
        return bookDao.findByCategory(category);
    }

    public List<Book> findByLanguage(String language) {
        return bookDao.findByLanguage(language);
    }

    public List<Book> getAllByLanguageAndCategory(String language, String category) {
        return bookDao.findBooksByLanguageAndCategory(language, category);
    }

    public void saveBook(Book book) {
        bookDao.save(book);
    }

    public void update(Book book) {
       bookDao.update(book);
    }

    public void deleteById(Long id) {
        bookDao.deleteById(id);
    }
}
