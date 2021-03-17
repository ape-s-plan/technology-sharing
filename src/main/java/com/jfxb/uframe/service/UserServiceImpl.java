package com.jfxb.uframe.service;

import com.jfxb.uframe.entity.User;
import com.jfxb.uframe.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAll() throws Exception {
        return userMapper.selectAll();
    }

    @Override
    public User getByName(String name) throws Exception {
        return userMapper.selectByName(name);
    }

    @Override
    public void editByName(String name) throws Exception {
        userMapper.updateByName(name);
    }

    @Override
    public void delByName(String name) throws Exception {
        userMapper.deleteByName(name);
    }

    @Override
    public void addUser(User user) throws Exception {
        userMapper.insertUser(user);
    }
}
