package com.htp.ex.dao.impl;

import com.htp.ex.dao.ShopDao;
import com.htp.ex.extractor.BookExtractor;
import com.htp.ex.mapper.BookPriceMapper;
import com.htp.ex.mapper.ShopMapper;
import com.htp.ex.model.BookPrice;
import com.htp.ex.model.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShopDaoImpl implements ShopDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Shop> findAllShopsWithCountriesAndCitiesAndAccounts() {
        String sql = "select shop.id as sh_id, shop.name as sh_name, " +
                "co_id, co_name, ci_id, ci_name, " +
                "account.id as ac_id, account.amount as ac_amount from " +
                "shop join (select country.id as co_id, country.name as co_name, city.id as ci_id, city.name as ci_name " +
                "from city join country on city.country_id = country.id) as stat1 " +
                "on shop.city_id = stat1.ci_id " +
                "join account on shop.account_id = account.id";

        return jdbcTemplate.query(sql, new ShopMapper());
    }
}
