package com.htp.ex.dao;

import com.htp.ex.model.Book;

import java.util.List;

public interface BookDao {

    List<Book> findAll ();

    List<Book> findAllBooksAndAuthors();

    Book findBookById(Integer id);

    void update(Book book);

    void save(Book book);

    void delete(Integer id);

    List<Book> findBooksByAuthorId(Integer id);
}
