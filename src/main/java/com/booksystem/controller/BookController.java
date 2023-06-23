package com.booksystem.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.booksystem.service.*;
import com.booksystem.bean.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/book")
public class BookController {
    @Autowired
    private BookService BookService;

    @GetMapping("/getAll")
    public @ResponseBody ResponseEntity<List<Book>> all() {
        return new ResponseEntity<>(BookService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/getById/{bookId}")
    public @ResponseBody ResponseEntity<?> getById(@PathVariable Long bookId) {
        Book book = BookService.find(bookId);

        if (book == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("/getByName/{bookName}")
    public @ResponseBody ResponseEntity<?> getByBookName(@PathVariable String bookName) {
        List<Book> book = BookService.findByNameLike("%" + bookName + "%");
        if (book.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PostMapping("/addBook")
    public ResponseEntity<?> post(@RequestBody Book Book, UriComponentsBuilder ucBuilder) {
        Book existBook = BookService.find(Book.getId());
        if (existBook != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        BookService.save(Book);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(Book, headers, HttpStatus.CREATED);
    }

    @PostMapping("/updateBook")
    public ResponseEntity<?> post(@RequestBody Book Book) {
        Book existBook = BookService.find(Book.getId());
        if (existBook == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        BookService.save(Book);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(Book, headers, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity<?> delete(@PathVariable int bookId) {
        BookService.delete(bookId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
