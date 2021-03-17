package com.jfxb.uframe.service;

import com.jfxb.uframe.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll() throws Exception;
    User getByName(String name) throws Exception;
    void editByName(String name) throws Exception;
    void delByName(String name) throws Exception;
    void addUser(User user) throws Exception;
}
