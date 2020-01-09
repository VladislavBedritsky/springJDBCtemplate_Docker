package com.htp.ex.service;

import com.htp.ex.model.BookPrice;

import java.util.List;

public interface BookPriceService {

    List<BookPrice> findAllShopsWithCountriesAndCitiesAndAccountsAndAuthorsWithCitiesAndCountriesByBookId(Integer id);
}
