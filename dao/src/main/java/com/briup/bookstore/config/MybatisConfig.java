package com.briup.bookstore.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @className: MybatisConfig
 * @Description:
 * @author: qinyc
 * @date: 2023/7/18 22:46
 * @version: v1.0
 */
@Configuration
@MapperScan("com.briup.bookstore.mapper")
public class MybatisConfig {
}
