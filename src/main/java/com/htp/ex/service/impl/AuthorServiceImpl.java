package com.htp.ex.service.impl;

import com.htp.ex.dao.DaoProvider;
import com.htp.ex.model.Author;
import com.htp.ex.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private DaoProvider daoProvider;

    @Override
    public Author findById(Integer id) {
        return daoProvider.getAuthorDao().findById(id);
    }

    @Override
    public List<Author> findAll() {
        return daoProvider.getAuthorDao().findAll();
    }

    @Override
    public void save(Author author) {
        daoProvider.getAuthorDao().save(author);
    }

    @Override
    public void update(Author author) {
        daoProvider.getAuthorDao().update(author);
    }
}
