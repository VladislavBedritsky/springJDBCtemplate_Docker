package com.htp.ex.dao.impl;

import com.htp.ex.dao.BookPriceDao;
import com.htp.ex.mapper.BookPriceMapper;
import com.htp.ex.model.BookPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookPriceDaoImpl implements BookPriceDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<BookPrice> findAllShopsWithCountriesAndCitiesAndAccountsAndAuthorsWithCitiesAndCountriesByBookId(Integer id) {
        String sql = "";

        return jdbcTemplate.query(sql, new BookPriceMapper(), id);
    }
}
