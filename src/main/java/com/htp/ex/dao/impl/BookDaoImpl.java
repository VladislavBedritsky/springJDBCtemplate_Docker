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
        String sql = "select * from book";
        return jdbcTemplate.query(sql,new BookMapper());
    }

    @Override
    public List<Book> findAllBooksAndAuthors() {
        String sql = "select book.id as b_id, book.name as b_name, author.name as a_name, " +
                "author.age as a_age, author.id as a_id from " +
                "book join author on book.author_id = author.id";
        return jdbcTemplate.query(sql, new BookExtractor());
    }

    @Override
    public Book findBookById(Integer id) {
        String sql = "select * from book where id=?";
        return jdbcTemplate.queryForObject(sql,new BookMapper(),id);
    }

    @Override
    public void update(Book book) {
        String sql = "update book set name=? where id=?";
        jdbcTemplate.update(sql,book.getName(),book.getId());
    }

    @Override
    public void save(Book book) {
        String sql = "insert into book (name,author_id) values (?,?)";
        jdbcTemplate.update(sql,book.getName(),book.getAuthor().getId());
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from book where id = ?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public List<Book> findBooksByAuthorId(Integer id) {
        String sql = "select book.id as b_id, book.name as b_name, author.name as a_name, " +
                "author.age as a_age, author.id as a_id from " +
                "book join author on book.author_id = author.id where author.id = ?";
        return jdbcTemplate.query(sql, new BookExtractor(), id);
    }
}
