package com.demo.jwt.config;

import com.demo.jwt.jwt.JWTInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @Description: JWT拦截器
 * @Date: 2022/4/5 17:30
 * @Author: Yang Yezhuang
 */
@Configuration
public class IntercaptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptor())
                //拦截的路径
                .addPathPatterns("/info/*", "/test")

                //排除接口
                .excludePathPatterns("/", "/login", "/register");
    }
}

