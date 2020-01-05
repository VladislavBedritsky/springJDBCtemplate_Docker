package com.htp.ex.service;

import com.htp.ex.model.Author;

import java.util.List;

public interface AuthorService {

    Author findById (Integer id);

    List<Author> findAll();

    void save (Author author);

    void update(Author author);
}
