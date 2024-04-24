package ru.edu.springdata.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.edu.springdata.model.Book;

import java.util.List;

@Component
public class BookDaoImpl implements BookDao {

    private final JdbcTemplate jdbcTemplate;

    public BookDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Book> findAll() {
        return jdbcTemplate.query("SELECT * FROM books", new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public List<Book> findByCategory(String category) {
        return jdbcTemplate.query("SELECT * FROM books WHERE category = ?",
                new Object[]{category}, new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public List<Book> findByLanguage(String language) {
        return jdbcTemplate.query("SELECT * FROM books WHERE language = ?",
                new Object[]{language}, new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public List<Book> findBooksByLanguageAndCategory(String language, String category) {
        return jdbcTemplate.query("SELECT * FROM books WHERE language = ? AND category = ?",
                new Object[]{language, category}, new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO books (name, language, category) VALUES (?,?,?)",
                book.getName(), book.getLanguage(), book.getCategory());
    }

    @Override
    public void update(Book book) {
        jdbcTemplate.update("UPDATE books SET name = ?, language = ?, category = ?) WHERE id = ?",
                book.getName(), book.getLanguage(), book.getCategory(), book.getId());
    }

    @Override
    public void deleteById(long id) {
        jdbcTemplate.update("DELETE FROM books WHERE id = ?", id);
    }
}
