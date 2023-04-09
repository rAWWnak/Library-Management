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

import com.xfactor.openlibrary.domain.Author;
import com.xfactor.openlibrary.repositories.AuthorRepository;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("authors")
public class AuthorController{
    private AuthorRepository authorRepository;
    
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @PostMapping("/saveAuthors")
    public Author saveAuthor(@RequestBody Author Author){
        if(Author.getId()==null){
            Author author2 = authorRepository.save(Author);
            return author2;
        }
        return null;
    }

    @PutMapping("/updateAuthor")
    public Author updateAuthor(@RequestBody Author author) {
        if (author.getId() != null) {
            Author author2 = authorRepository.save(author);
            return author2;
        }
        return null;
    }

    @GetMapping("/getAllAuthors")
    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    @GetMapping("/findTotalAuthors")
    public Long findTotalAuthors(){
        return authorRepository.count();
    }

    @GetMapping("findByAuthorId/{id}")
    public Author findById(@PathVariable Long id) {
        Optional<Author> optionalOfAuthor = authorRepository.findById(id);
        if (optionalOfAuthor.isPresent()) {
            return optionalOfAuthor.get();
        }
        return null;
    }

    @GetMapping("findByname/{name}")
    public List<Author> findByisbn(@PathVariable String name) {
        List<Author> authors = authorRepository.findByName(name);
        return authors;
    }

    @DeleteMapping("deleteAuthors/{id}")
    public void deleteAuthors(@PathVariable Long id){
        authorRepository.deleteById(id);
    }
}