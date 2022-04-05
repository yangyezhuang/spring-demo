package com.demo.jwt.model;

import lombok.Data;

/**
 * @Description: User实体类
 * @Date: 2022/4/5 15:23
 * @Author: Yang Yezhuang
 */
@Data
public class User {
    Long id;
    String username;
    String password;
    String role;
    String permission;
}
