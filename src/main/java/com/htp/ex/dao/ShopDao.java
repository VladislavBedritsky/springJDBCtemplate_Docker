package com.htp.ex.dao;

import com.htp.ex.model.Shop;

import java.util.List;

public interface ShopDao {

    List<Shop> findAllShopsWithCountriesAndCitiesAndAccounts ();

}
