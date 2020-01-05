package com.htp.ex.dao.impl;

import com.htp.ex.dao.AuthorDao;
import com.htp.ex.mapper.AuthorMapper;
import com.htp.ex.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorDaoImpl implements AuthorDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Author findById(Integer id) {
        String sql = "select * from authors where id=?";
        return  jdbcTemplate.queryForObject(sql, new AuthorMapper(), id);
    }

    @Override
    public List<Author> findAll() {
        String sql = "select * from authors";
        return jdbcTemplate.query(sql,new AuthorMapper());
    }

    @Override
    public void save(Author author) {
        String sql = "insert into authors (name,age) values (?,?)";
        jdbcTemplate.update(sql,author.getName(),author.getAge());
    }

    @Override
    public void update(Author author) {
        String sql = "update authors set name=?,age=? where id = ?";
        jdbcTemplate.update(sql,author.getName(),author.getAge(),author.getId());
    }
}
