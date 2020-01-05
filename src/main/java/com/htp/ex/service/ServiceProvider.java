package com.htp.ex.service;

import com.htp.ex.service.impl.AuthorServiceImpl;
import com.htp.ex.service.impl.BookServiceImpl;
import com.htp.ex.service.impl.UserServiceImpl;
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

    public AuthorService getAuthorService() {
        return authorService;
    }

    public BookService getBookService() {
        return bookService;
    }

    public UserService getUserService() {
        return userService;
    }
}
