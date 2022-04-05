package com.demo.jwt.jwt;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: token 拦截器
 * @Date: 2022/4/5 17:26
 * @Author: Yang Yezhuang
 */
@Slf4j
public class JWTInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader("token");
        log.info("token：" + token);

        if (token == null) {
            log.error("token为空");
        }
        try {
            JwtUtil.verifyToken(token);
        } catch (SignatureVerificationException e) {
            log.error("无效签名");
            return false;
        } catch (TokenExpiredException e) {
            log.error("token过");
            return false;
        } catch (AlgorithmMismatchException e) {
            log.error("token算法不一致");
            return false;
        } catch (Exception e) {
            log.error("token无效");
            return false;
        }
        return true;
    }
}
