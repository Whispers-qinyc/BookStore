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

 * @author: adam
 * @date: 2023/7/25
 * @Description: Knife4j配置类
 */
@Configuration
@EnableSwagger2
public class Knife4jConfig {
    //Swagger界面中显示的基本信息
    private ApiInfo apiInfo(){
        //配置基本信息
        Contact briup = new Contact("adam", "http://www.briup.com/index.php/", "xueyz@briup.com");
        return new ApiInfoBuilder()
                //标题
                .title("杰普网上商城项目")
                .description("杰普网上商城项目用户端系统 接口管理文档")
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
