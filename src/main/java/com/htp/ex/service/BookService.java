package com.htp.ex.service;

import com.htp.ex.model.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll ();

    List<Book> findAllBooksAndAuthors();

    Book findBookById(Integer id);

    void update(Book book);

    void save(Book book);

    void delete(Integer id);

    List<Book> findBooksByAuthorId(Integer id);

}
