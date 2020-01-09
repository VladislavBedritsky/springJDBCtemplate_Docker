package com.htp.ex.mapper;

import com.htp.ex.model.Account;
import com.htp.ex.model.City;
import com.htp.ex.model.Country;
import com.htp.ex.model.Shop;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ShopMapper implements RowMapper<Shop> {

    @Override
    public Shop mapRow(ResultSet resultSet, int i) throws SQLException {
        Shop shop = new Shop();
        shop.setId(resultSet.getInt("sh_id"));
        shop.setName(resultSet.getString("sh_name"));

        City city = new City();
        city.setId(resultSet.getInt("ci_id"));
        city.setName(resultSet.getString("ci_name"));

        Country country = new Country();
        country.setId(resultSet.getInt("co_id"));
        country.setName(resultSet.getString("co_name"));

        city.setCountry(country);

        Account account = new Account();
        account.setId(resultSet.getInt("ac_id"));
        account.setAmountMoney(resultSet.getLong("ac_amount"));

        shop.setCity(city);
        shop.setAccount(account);

        return shop;
    }
}
