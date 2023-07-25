package com.briup.bookstore.config;

import com.briup.bookstore.web.interceptor.AdminCheckLoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @className: InterceptorConfig
 * @Description: 配置拦截器规则
 * @author: qinyc
 * @date: 2023/7/18 20:52
 * @version: v1.0
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    private AdminCheckLoginInterceptor adminCheckLoginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(adminCheckLoginInterceptor)
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
