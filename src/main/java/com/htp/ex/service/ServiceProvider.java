package com.htp.ex.service;

import com.htp.ex.dao.ShopDao;
import com.htp.ex.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceProvider {

    @Autowired
    private AuthorService authorService = new AuthorServiceImpl();

    @Autowired
    private BookService bookService = new BookServiceImpl();

    @Autowired
    private UserService userService = new UserServiceImpl();

    @Autowired
    private ShopService shopService = new ShopServiceImpl();

    @Autowired
    private BookPriceService bookPriceService = new BookPriceServiceImpl();

    public AuthorService getAuthorService() {
        return authorService;
    }

    public BookService getBookService() {
        return bookService;
    }

    public UserService getUserService() {
        return userService;
    }

    public ShopService getShopService() {
        return shopService;
    }

    public BookPriceService getBookPriceService() {
        return bookPriceService;
    }
}
