package com.htp.ex.service.impl;

import com.htp.ex.dao.DaoProvider;
import com.htp.ex.dao.impl.UserDaoImpl;
import com.htp.ex.model.User;
import com.htp.ex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private DaoProvider daoProvider;

    @Override
    public List<User> findAll() {
        return daoProvider.getUserDao().findAll();
    }

    @Override
    public void save(User user) {
        daoProvider.getUserDao().save(user);
    }

    @Override
    public User getById(int id) {
        return daoProvider.getUserDao().getById(id);
    }

    @Override
    public void update(User user) {
        daoProvider.getUserDao().update(user);
    }

    @Override
    public void delete(int id) {
        daoProvider.getUserDao().delete(id);
    }


}
