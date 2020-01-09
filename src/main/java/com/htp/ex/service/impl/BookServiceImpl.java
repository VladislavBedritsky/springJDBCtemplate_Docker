package com.htp.ex.service.impl;

import com.htp.ex.dao.DaoProvider;
import com.htp.ex.dao.impl.BookDaoImpl;
import com.htp.ex.model.Book;
import com.htp.ex.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private DaoProvider daoProvider;


    @Override
    public List<Book> findAll() {
        return daoProvider.getBookDao().findAll();
    }

    @Override
    public List<Book> findAllBooksAndAuthors() {
        return daoProvider.getBookDao().findAllBooksAndAuthors();
    }

    @Override
    public Book findBookById(Integer id) {
        return daoProvider.getBookDao().findBookById(id);
    }

    @Override
    public void update(Book book) {
        daoProvider.getBookDao().update(book);
    }

    @Override
    public void save(Book book) {
        daoProvider.getBookDao().save(book);
    }

    @Override
    public void delete(Integer id) {
        daoProvider.getBookDao().delete(id);
    }

    @Override
    public List<Book> findBooksByAuthorId(Integer id) {
        return daoProvider.getBookDao().findBooksByAuthorId(id);
    }
}
