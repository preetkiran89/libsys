package com.example.libsys.serviceimpl;

import com.example.libsys.entities.Book;
import com.example.libsys.service.BookRepository;
import com.example.libsys.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //This needed in both Service interface & ServiceImpl TODO
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @Override
    public Book getBook(Long bookID) {
        Optional<Book> book= bookRepository.findById(bookID);
        if(book.isPresent())
            return book.get();
        else
            throw new IllegalStateException("Book ID is not valid!!!");
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book addBook(Book book) {
        if(!bookRepository.findAll().contains(book.getName()))
            bookRepository.save(book);
        else
            throw new IllegalStateException("Book, " + book.getName() + "already exists in DB!!!");
        return book;
    }

    @Override
    public void archiveBook(Long bookID) {
        Optional<Book> byId = bookRepository.findById(bookID);
        if(byId.isPresent()) {
            byId.get().setIsInArchive(Byte.valueOf("89"));
            bookRepository.save(byId.get());
            System.out.println("The book is OLD & hence archived!!! ");
        }
        else {
            throw new IllegalStateException("BookID for book to be archived is not valid!!!!!");
        }
    }
}
