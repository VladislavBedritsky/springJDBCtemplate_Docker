package com.htp.ex.dao.impl;

import com.htp.ex.dao.UserDao;
import com.htp.ex.mapper.UserMapper;
import com.htp.ex.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        return jdbcTemplate.query(sql,new UserMapper());
    }

    @Override
    public void save(User user) {
        String sql = "INSERT INTO user (name,email,age) VALUES (?,?,?)";
        jdbcTemplate.update(sql, user.getName(),user.getEmail(),user.getAge());
    }

    @Override
    public User getById(int id) {
        String sql = "select * from user where id=?";
        return jdbcTemplate.queryForObject(sql,new UserMapper(),id);
    }

    @Override
    public void update(User user) {
        String sql = "update user set name=?, email=?, age=? where id = ?";
        jdbcTemplate.update(sql, user.getName(),user.getEmail(),user.getAge(), user.getId());
    }

    @Override
    public void delete(int id) {
        String sql = "delete from user where id=?";
        jdbcTemplate.update(sql, id);
    }

}
