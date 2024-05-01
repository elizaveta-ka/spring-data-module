package ru.edu.springdata.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.edu.springdata.dto.BookDtoRequest;
import ru.edu.springdata.model.Book;
import ru.edu.springdata.service.BookService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    public final BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/get/{language}")
    public List<Book> getByLanguage(@PathVariable String language) {
        return bookService.findByLanguage(language);
    }

    @GetMapping("/get/{category}")
    public List<Book>  getByCategory(@PathVariable String category) {
        return bookService.findByCategory(category);
    }

    @PostMapping("/get")
    public List<Book>  getByLanguageAndCategory(@RequestBody BookDtoRequest request) {
        return bookService.getAllByLanguageAndCategory(request.getLanguage(), request.getCategory());
    }

    @PostMapping("/save")
    public void saveBook(@RequestBody Book book) {
        bookService.saveBook(book);
    }

    @PostMapping("/update")
    public void updateBook(@RequestBody Book book) {
        bookService.update(book);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable long id) {
        bookService.deleteById(id);
    }
}
