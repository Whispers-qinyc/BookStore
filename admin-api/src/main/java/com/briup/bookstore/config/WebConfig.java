package com.briup.bookstore.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @className: WebConfig
 * @Description: 解决跨域问题
 * @author: qinyc
 * @date: 2023/7/18 20:50
 * @version: v1.0
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * @Author qinyc
     * @Description  解决跨域问题
     * @version: v1.0
     * @Date 20:52 2023/7/18
     **/
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
}
