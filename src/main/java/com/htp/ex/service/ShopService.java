package com.htp.ex.service;

import com.htp.ex.model.Shop;

import java.util.List;

public interface ShopService {

    List<Shop> findAllShopsWithCountriesAndCitiesAndAccounts ();

    List<Shop> findAllShopsWithCountriesAndCitiesAndAccountsAndAuthorsWithCitiesAndCountriesByBookId(Integer id);
}
