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

import com.xfactor.openlibrary.domain.Publisher;
import com.xfactor.openlibrary.repositories.PublisherRepository;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("publishers")
public class PublisherController{
    private PublisherRepository publisherRepository;
    
    public PublisherController(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @PostMapping("/savePublishers")
    public Publisher savePublisher(@RequestBody Publisher Publisher){
        if(Publisher.getId()==null){
            Publisher publisher2 = publisherRepository.save(Publisher);
            return publisher2;
        }
        return null;
    }

    @PutMapping("/updatePublisher")
    public Publisher updatePublisher(@RequestBody Publisher publisher) {
        if (publisher.getId() != null) {
            Publisher publisher2 = publisherRepository.save(publisher);
            return publisher2;
        }
        return null;
    }

    @GetMapping("/getAllPublishers")
    public List<Publisher> getAllAPublisher(){
        return publisherRepository.findAll();
    }

    @GetMapping("/findTotalPublishers")
    public Long findTotalPublishers(){
        return publisherRepository.count();
    }
    
    @GetMapping("findByPublisherId/{id}")
    public Publisher findById(@PathVariable Long id) {
        Optional<Publisher> optionalOfPublisher = publisherRepository.findById(id);
        if (optionalOfPublisher.isPresent()) {
            return optionalOfPublisher.get();
        }
        return null;
    }

    @DeleteMapping("deletePublishers/{id}")
    public void deletePublishers(@PathVariable Long id){
        publisherRepository.deleteById(id);
    }

    @GetMapping("findByname/{name}")
    public List<Publisher> findByname(@PathVariable String name) {
        List<Publisher> publishers = publisherRepository.findByName(name);
        return publishers;
    }
}

