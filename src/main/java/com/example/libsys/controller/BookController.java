package com.example.libsys.controller;

import com.example.libsys.entities.Book;
import com.example.libsys.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/library")
public class BookController {

    private final BookService bookservice;

    @Autowired
    public BookController(BookService bookService) {
        this.bookservice = bookService;
    }

    @GetMapping(path = "/getBook/{bookID}")
    public Book getBook(@PathVariable("bookID") Long bookID) {
        return bookservice.getBook(bookID);
    }

    @RequestMapping(path = "/addBook", method = RequestMethod.POST)
    public Book addBook(@RequestBody Book book) {
        return bookservice.addBook(book);
    }

    @GetMapping(path="/getBooks")
    public List<Book> getBooks() {
        return bookservice.getBooks();
    }

    @RequestMapping(path = "/archiveBook/{bookID}", method = RequestMethod.POST)
    public void archiveBook(@PathVariable Long bookID) {
        bookservice.archiveBook(bookID);
    }
}
