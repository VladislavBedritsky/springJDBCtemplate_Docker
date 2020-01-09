package com.htp.ex.mapper;

import com.htp.ex.model.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class BookPriceMapper implements RowMapper<BookPrice> {

    @Override
    public BookPrice mapRow(ResultSet resultSet, int i) throws SQLException {
        BookPrice bookPrice = new BookPrice();
        bookPrice.setPrice(resultSet.getInt("bp_price"));

        Book book = new Book();
        book.setId(resultSet.getInt("b_id"));
        book.setName(resultSet.getString("b_name"));

        Author author = new Author();
        author.setId(resultSet.getInt("aut_id"));
        author.setName(resultSet.getString("aut_name"));
        author.setAge(resultSet.getInt("aut_age"));

        City authorCity = new City();
        authorCity.setId(resultSet.getInt("aut_ci_id"));
        authorCity.setName(resultSet.getString("aut_ci_name"));

        Country authorCountry = new Country();
        authorCountry.setId(resultSet.getInt("aut_co_id"));
        authorCountry.setName(resultSet.getString("aut_co_name"));

        authorCity.setCountry(authorCountry);
        author.setCity(authorCity);
        book.setAuthor(author);
        bookPrice.setBook(book);


        Shop shop = new Shop();
        shop.setId(resultSet.getInt("sh_id"));
        shop.setName(resultSet.getString("sh_name"));

        City city = new City();
        city.setId(resultSet.getInt("sh_ci_id"));
        city.setName(resultSet.getString("sh_ci_name"));

        Country country = new Country();
        country.setId(resultSet.getInt("sh_co_id"));
        country.setName(resultSet.getString("sh_co_name"));

        city.setCountry(country);

        Account account = new Account();
        account.setId(resultSet.getInt("ac_id"));
        account.setAmountMoney(resultSet.getLong("ac_amount"));

        shop.setCity(city);
        shop.setAccount(account);

        bookPrice.setShop(shop);

        return bookPrice;
    }
}
