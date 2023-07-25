package com.briup.bookstore.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 
 * @TableName es_book
 */

@ApiModel("收货地址实体类")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Book {
    /**
     * 图书主键ID
     */
    @ApiModelProperty("图书主键ID")
    private Integer id;

    /**
     * 图书名称
     */
    @ApiModelProperty("图书名称")
    private String name;

    /**
     * 图书封面图片
     */
    @ApiModelProperty("图书封面图片")
    private String cover;

    /**
     * 图书简介
     */
    @ApiModelProperty("图书简介")
    private String description;

    /**
     * 图书作者
     */
    @ApiModelProperty("图书作者")
    private String author;

    /**
     * 图书出版社
     */
    @ApiModelProperty("图书出版社")
    private String publisher;

    /**
     * 图书价格
     */
    @ApiModelProperty("图书价格")
    private Double price;

    /**
     * 库存数量
     */
    @ApiModelProperty("库存数量")
    private Integer storeNum;

    /**
     * 图书状态  0: 上架 1：下架
     */
    @ApiModelProperty("图书状态  0: 上架 1：下架")
    private Integer status;

    /**
     * 图书分类ID
     */
    @ApiModelProperty("图书分类ID")
    private Integer categoryId;
}