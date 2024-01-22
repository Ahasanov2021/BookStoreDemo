package com.example.demo.service;

import com.example.demo.model.Book;

import java.util.List;

public interface BookService {

    Book create(Book book);

    Book update(Integer id, Book book);

    void delete(Integer id);

    Book get(Integer id);

    List<Book> findAll();
}
