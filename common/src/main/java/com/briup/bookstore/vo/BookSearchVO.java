package com.briup.bookstore.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: BookSearchVO
 * @Description: 接收前断传递过来的查询条件
 * @Author: songjl
 * @Date: 2023/7/20 16:00
 * @Version: v1.0
 */
@ApiModel("图书查询条件对象")
@Data
public class BookSearchVO {

    @ApiModelProperty("书名")
    private String name;

    @ApiModelProperty("作者")
    private String author;

    @ApiModelProperty("出版社")
    private String publisher;

}
