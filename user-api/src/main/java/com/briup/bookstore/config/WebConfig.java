package com.briup.bookstore.config;

import com.briup.bookstore.web.Interceptor.UserLoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: adam
 * @date: 2023/7/25 20:50
 * @Description: 解决跨域问题
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private UserLoginInterceptor userLoginInterceptor;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 设置允许跨域的路径
        registry.addMapping("/**")
                // 设置允许跨域请求的域名
                .allowedOriginPatterns("*")
                // 是否允许cookie
                .allowCredentials(true)
                // 设置允许的请求方式
                .allowedMethods("GET", "POST", "DELETE", "PUT","HEAD","OPTIONS")
                // 设置允许的header属性
                .allowedHeaders("*")
                // 跨域允许时间
                .maxAge(3600);
    }



    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userLoginInterceptor)
                //拦截所有请求
                .addPathPatterns("/**")
                //除了登录、注册请求 Swagger相关请求
                .excludePathPatterns
                        ("/admin/login","/admin/register",
                                "/profile/**",
                                "/common/download**",
                                "/common/download/resource**",
                                "/swagger-ui.html",
                                "/swagger-resources/**",
                                "/webjars/**",
                                "/*/api-docs",
                                "/druid/**",
                                "/favicon.ico",
                                "/doc.html");
    }
}
