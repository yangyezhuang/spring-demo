package com.demo.jwt.service;

import com.demo.jwt.mapper.UserMapper;
import com.demo.jwt.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: UserService
 * @Date: 2022/4/5 15:27
 * @Author: Yang Yezhuang
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User login(String username) {
      return   userMapper.queryByUsername(username);
    }
}
