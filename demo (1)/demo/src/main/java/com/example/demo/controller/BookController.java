package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book/v1")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public Book get(@PathVariable Integer id) {
        return bookService.get(id);
    }

    @GetMapping()
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @PostMapping
    public Book create(@RequestBody Book book){
        return bookService.create(book);
    }

    @PutMapping("{id}")
    public Book update(@PathVariable Integer id, @RequestBody Book book){
        return bookService.update(id, book);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        bookService.delete(id);
    }
}
