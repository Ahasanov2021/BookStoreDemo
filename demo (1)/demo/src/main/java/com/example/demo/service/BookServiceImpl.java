package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository studentRepository) {
        this.bookRepository = studentRepository;
    }

    @Override
    public Book create(Book book) {
        log.info("Create method is working");
        Book bookInDb = bookRepository.save(book);
        return bookInDb;
    }

    @Override
    public Book update(Integer id, Book book){
        log.info("Update method is working");
        Book entity = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));

        if(book.getGenre() != null)
            entity.setGenre(book.getGenre());
        if(book.getPages() != null)
            entity.setPages(book.getPages());
        if(book.getLanguage() != null)
            entity.setLanguage(book.getLanguage());
        if(book.getStock() != null)
            entity.setStock(book.getStock());
        if(book.getTitle() != null)
            entity.setTitle(book.getTitle());
        if(book.getAuthorName() != null)
            entity.setAuthorName(book.getAuthorName());
        if(book.getPublishDate() != null)
            entity.setPublishDate(book.getPublishDate());
        if(book.getPrice() != null)
            entity.setPrice(book.getPrice());
        entity = bookRepository.save(entity);
        return entity;
    }

    @Override
    public void delete(Integer id){
        log.info("Delete method is working");
        bookRepository.deleteById(id);
    }

    @Override
    public Book get(Integer id) {
        log.info("Get method is working");
        Optional<Book> book = bookRepository.findById(id);
        if(book.isEmpty()){
            throw new RuntimeException("Book not found");
        }
        return book.get();
    }

    @Override
    public List<Book> findAll() {
        log.info("Get method is working");
        return bookRepository.findAll();
    }


}
