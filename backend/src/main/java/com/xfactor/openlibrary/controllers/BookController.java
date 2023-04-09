package com.xfactor.openlibrary.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xfactor.openlibrary.domain.Book;
import com.xfactor.openlibrary.repositories.BookRepository;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("books")
public class BookController{
    private BookRepository bookRepository;
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping("/saveBooks")
    public Book saveBook(@RequestBody Book Book){
        if(Book.getId()==null){
            Book book2 = bookRepository.save(Book);
            return book2;
        }
        return null;
    }

    @PutMapping("/updateBook")
    public Book updateBook(@RequestBody Book book) {
        if (book.getId() != null) {
            Book book2 = bookRepository.save(book);
            return book2;
        }
        return null;
    }

    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    @GetMapping("/findTotalBooks")
    public Long findTotalBooks(){
        return bookRepository.count();
    }
    
    @GetMapping("findByBookId/{id}")
    public Book findById(@PathVariable Long id) {
        Optional<Book> optionalOfBook = bookRepository.findById(id);
        if (optionalOfBook.isPresent()) {
            return optionalOfBook.get();
        }
        return null;
    }

    @DeleteMapping("deleteBooks/{id}")
    public void deleteBooks(@PathVariable Long id){
        bookRepository.deleteById(id);
    }

    @GetMapping("findByisbn/{isbn}")
    public List<Book> findByisbn(@PathVariable String isbn) {
        List<Book> books = bookRepository.findByIsbn(isbn);
        return books;
    }
}

