package com.htp.ex.extractor;

import com.htp.ex.model.Author;
import com.htp.ex.model.Book;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookExtractor implements ResultSetExtractor<List<Book>> {
    @Override
    public List<Book> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        List<Book> list = new ArrayList<>();
        while (resultSet.next()) {
            Book book = new Book();
            book.setId(resultSet.getInt("b_id"));
            book.setName(resultSet.getString("b_name"));
            book.setPrice(resultSet.getInt("b_price"));

            Author author = new Author();
            author.setId(resultSet.getInt("a_id"));
            author.setName(resultSet.getString("a_name"));
            author.setAge(resultSet.getInt("a_age"));

            book.setAuthor(author);
            list.add(book);
        }
        return list;
    }
}
