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
        String sql = "SELECT book_price.price AS bp_price, " +
                "b_id, b_name, aut_ci_id, aut_ci_name, aut_co_id, aut_co_name, aut_id, aut_name, aut_age, " +
                "sh_id, sh_name, ac_id, ac_amount, sh_ci_id, sh_ci_name, sh_co_id, sh_co_name " +
                "FROM book_price JOIN " +
                "(SELECT book.id AS b_id, book.name AS b_name, " +
                "aut_ci_id, aut_ci_name, aut_co_id, aut_co_name, aut_id, aut_name, aut_age FROM book JOIN " +
                "(SELECT aut_ci_id, aut_ci_name, aut_co_id, aut_co_name, author.id AS aut_id, author.name AS aut_name, author.age AS aut_age " +
                "FROM author JOIN " +
                "(SELECT city.id AS aut_ci_id, city.name AS aut_ci_name, country.id AS aut_co_id, country.name AS aut_co_name " +
                "FROM city JOIN country ON city.country_id = country.id) " +
                "AS aut_co_ci ON author.city_id = aut_co_ci.aut_ci_id) " +
                "AS book_aut ON book.author_id = book_aut.aut_id) " +
                "AS b_aut_co_ci ON book_price.book_id = b_aut_co_ci.b_id JOIN " +
                "(SELECT shop.id AS sh_id, shop.name AS sh_name, " +
                "account.id AS ac_id, account.amount AS ac_amount, " +
                "sh_ci_id, sh_ci_name, sh_co_id, sh_co_name FROM shop JOIN " +
                "(SELECT city.id AS sh_ci_id, city.name AS sh_ci_name, country.id AS sh_co_id, country.name AS sh_co_name " +
                "FROM city JOIN country ON city.country_id = country.id) " +
                "AS sh_ci_co ON shop.city_id = sh_ci_co.sh_ci_id " +
                "JOIN account ON shop.account_id = account.id) " +
                "AS sh_acc_ci_co " +
                "ON book_price.shop_id = sh_acc_ci_co.sh_id WHERE b_id = ?";

        return jdbcTemplate.query(sql, new BookPriceMapper(), id);
    }
}
