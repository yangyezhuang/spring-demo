package com.demo.jwt.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.demo.jwt.model.User;
import org.springframework.stereotype.Service;


import java.util.Calendar;

/**
 * @Description: token工具类
 * @Date: 2022/4/5 15:37
 * @Author: Yang yezhuang
 */
@Service
public class JwtUtil {

    /**
     * 生成token
     *
     * @param user
     * @return
     */
    public static String createToken(User user) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 7); //默认令牌过期时间7天

        JWTCreator.Builder builder = JWT.create();

        builder.withClaim("uid", user.getId())
                .withClaim("username", user.getUsername())
                .withClaim("role", user.getRole())
                .withClaim("permission", user.getPermission());

        return builder.withExpiresAt(calendar.getTime())
                .sign(Algorithm.HMAC256(user.getPassword()));
    }

    /**
     * 解析token
     *
     * @param token
     * @return
     */
    public static DecodedJWT verifyToken(String token) {
        if (token == null) {
            System.out.println("token不能为空");
        }

        //获取登录用户真正的密码假如数据库查出来的是123456
        String password = "admin";
        JWTVerifier build = JWT.require(Algorithm.HMAC256(password)).build();
        return build.verify(token);
    }
}
