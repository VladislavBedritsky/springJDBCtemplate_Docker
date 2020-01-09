package com.htp.ex.service.impl;

import com.htp.ex.dao.DaoProvider;
import com.htp.ex.model.BookPrice;
import com.htp.ex.service.BookPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookPriceServiceImpl implements BookPriceService {

    @Autowired
    private DaoProvider daoProvider;

    @Override
    public List<BookPrice> findAllShopsWithCountriesAndCitiesAndAccountsAndAuthorsWithCitiesAndCountriesByBookId(Integer id) {
        return daoProvider.getBookPriceDao().findAllShopsWithCountriesAndCitiesAndAccountsAndAuthorsWithCitiesAndCountriesByBookId(id);
    }
}
