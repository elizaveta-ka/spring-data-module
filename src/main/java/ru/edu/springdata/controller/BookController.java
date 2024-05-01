package ru.edu.springdata.controller;


import org.springframework.web.bind.annotation.*;
import ru.edu.springdata.dto.BookDtoRequest;
import ru.edu.springdata.entity.Book;
import ru.edu.springdata.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    public final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id).orElseThrow(() -> new RuntimeException("Book is not found"));
    }

    @PostMapping
    public Book saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @PostMapping("/update")
    public void updateBook(@RequestBody Book book) {
        bookService.saveBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable Long id) {
        bookService.deleteBookById(id);
    }


    @GetMapping("/get/language/{language}")
    public List<Book> getByLanguage(@PathVariable String language) {
        return bookService.findByLanguage(language);
    }

    @GetMapping("/get/category/{category}")
    public List<Book>  getByCategory(@PathVariable Long category) {
        return bookService.findByCategory(category);
    }

    @PostMapping("/get")
    public List<Book>  getByLanguageAndCategory(@RequestBody BookDtoRequest request) {
        return bookService.getAllByLanguageAndCategory(request.getLanguage(), request.getCategory());
    }
}
