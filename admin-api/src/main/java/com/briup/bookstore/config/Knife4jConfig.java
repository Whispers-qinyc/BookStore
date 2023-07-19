package com.briup.bookstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @className: Knife4jConfig
 * @Description: Knife4j配置类
 * @author: qinyc
 * @date: 2023/7/18 17:09
 * @version: v1.0
 */
@Configuration
@EnableSwagger2
public class Knife4jConfig {
    //Swagger界面中显示的基本信息
    private ApiInfo apiInfo(){
        //配置基本信息
        Contact briup = new Contact("briup", "http://www.briup.com/index.php/", "3052996575@qq.com");
        return new ApiInfoBuilder()
                //标题
                .title("书城项目-后台管理系统")
                .description("欢迎访问书城项目后台管理系统接口文档")
                //基本信息
                .contact(briup)
                //版本号
                .version("1.0.0")
                //创建
                .build();
    }

    //配置Controller的包路径
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //传入要扫描的包结构
                .apis(RequestHandlerSelectors.basePackage("com.briup.bookstore.web.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
