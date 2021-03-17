package com.jfxb.uframe.mapper;

import com.jfxb.uframe.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public List<User> selectAll() throws Exception;
    User selectByName(String name) throws Exception;
    void updateByName(String name) throws Exception;
    void deleteByName(String name) throws Exception;
    void insertUser(User user) throws Exception;
}
