package com.htp.ex.dao;

import com.htp.ex.dao.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DaoProvider {

    @Autowired
    private UserDao userDao = new UserDaoImpl();

    @Autowired
    private AuthorDao authorDao = new AuthorDaoImpl();

    @Autowired
    private BookDao bookDao = new BookDaoImpl();

    @Autowired
    private ShopDao shopDao = new ShopDaoImpl();

    @Autowired
    private BookPriceDao bookPriceDao = new BookPriceDaoImpl();

    public UserDao getUserDao() {
        return userDao;
    }

    public AuthorDao getAuthorDao() {
        return authorDao;
    }

    public BookDao getBookDao() {
        return bookDao;
    }

    public ShopDao getShopDao() {
        return shopDao;
    }

    public BookPriceDao getBookPriceDao() {
        return bookPriceDao;
    }
}
