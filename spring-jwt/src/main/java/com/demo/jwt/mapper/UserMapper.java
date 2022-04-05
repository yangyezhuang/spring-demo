package com.demo.jwt.mapper;

import com.demo.jwt.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Description: UserMapper
 * @Date: 2022/4/5 15:25
 * @Author: Yang Yezhuang
 */
@Mapper
public interface UserMapper {

    @Select("select * from user_tb where username=#{username};")
    User queryByUsername(String username);

}
