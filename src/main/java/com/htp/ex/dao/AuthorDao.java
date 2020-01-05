package com.htp.ex.dao;

import com.htp.ex.model.Author;

import java.util.List;

public interface AuthorDao {

    Author findById(Integer id);

    List<Author> findAll();

    void save (Author author);

    void update(Author author);
}
