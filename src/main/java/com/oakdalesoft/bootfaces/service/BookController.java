package com.oakdalesoft.bootfaces.service;

import com.oakdalesoft.bootfaces.domain.Book;
import com.oakdalesoft.bootfaces.persistence.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Alex on 18/03/2015.
 */

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping("/service/books")
    public @ResponseBody
    Iterable<Book> getAllBooks() {
        return this.bookRepository.findAll();
    }
    
    @RequestMapping(value="/service/book/{id}", method=RequestMethod.GET)
    public @ResponseBody Book getBookById(@PathVariable Long id) {
        return this.bookRepository.findOne(id);
    }
}
