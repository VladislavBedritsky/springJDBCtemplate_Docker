package com.htp.ex.dao;

import com.htp.ex.model.BookPrice;

import java.util.List;

public interface BookPriceDao {

    List<BookPrice> findAllShopsWithCountriesAndCitiesAndAccountsAndAuthorsWithCitiesAndCountriesByBookId(Integer id);
}
