package com.htp.ex.dao;

import com.htp.ex.dao.impl.AuthorDaoImpl;
import com.htp.ex.dao.impl.BookDaoImpl;
import com.htp.ex.dao.impl.UserDaoImpl;
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


    public UserDao getUserDao() {
        return userDao;
    }

    public AuthorDao getAuthorDao() {
        return authorDao;
    }

    public BookDao getBookDao() {
        return bookDao;
    }

}
