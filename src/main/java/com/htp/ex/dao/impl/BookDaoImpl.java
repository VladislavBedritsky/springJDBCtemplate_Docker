package com.htp.ex.dao.impl;

import com.htp.ex.dao.BookDao;
import com.htp.ex.extractor.BookExtractor;
import com.htp.ex.mapper.BookMapper;
import com.htp.ex.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Book> findAll() {
        String sql = "select * from books";
        return jdbcTemplate.query(sql,new BookMapper());
    }

    @Override
    public List<Book> findAllBooksAndAuthors() {
        String sql = "select books.id as b_id, books.name as b_name, books.price as b_price, authors.name as a_name, " +
                "authors.age as a_age, authors.id as a_id from " +
                "books join authors on books.author_id = authors.id";
        return jdbcTemplate.query(sql, new BookExtractor());
    }

    @Override
    public Book findBookById(Integer id) {
        String sql = "select * from books where id=?";
        return jdbcTemplate.queryForObject(sql,new BookMapper(),id);
    }

    @Override
    public void update(Book book) {
        String sql = "update books set name=?,price=? where id=?";
        jdbcTemplate.update(sql,book.getName(),book.getPrice(),book.getId());
    }

    @Override
    public void save(Book book) {
        String sql = "insert into books (name,price,author_id) values (?,?,?)";
        jdbcTemplate.update(sql,book.getName(),book.getPrice(),book.getAuthor().getId());
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from books where id = ?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public List<Book> findBooksByAuthorId(Integer id) {
        String sql = "select books.id as b_id, books.name as b_name, books.price as b_price, authors.name as a_name, " +
                "authors.age as a_age, authors.id as a_id from " +
                "books join authors on books.author_id = authors.id where authors.id = ?";
        return jdbcTemplate.query(sql, new BookExtractor(),id);
    }
}
