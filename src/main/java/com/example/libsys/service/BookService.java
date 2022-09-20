package com.example.libsys.service;

import com.example.libsys.entities.Book;
import com.example.libsys.entities.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //If this not defined, BookController constructor not initialized even after Autowired use it internally TODO
public interface BookService {
    Book getBook(Long bookID);
    List<Book> getBooks();
    Book addBook(Book book);
    void archiveBook(Long bookID);
}
