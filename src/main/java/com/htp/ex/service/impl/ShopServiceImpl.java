package com.htp.ex.service.impl;

import com.htp.ex.dao.DaoProvider;
import com.htp.ex.model.Shop;
import com.htp.ex.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private DaoProvider daoProvider;

    @Override
    public List<Shop> findAllShopsWithCountriesAndCitiesAndAccounts() {
        return daoProvider.getShopDao().findAllShopsWithCountriesAndCitiesAndAccounts();
    }

}
