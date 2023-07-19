package com.briup.bookstore.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 
 * @TableName es_category
 */
@ApiModel("分类实体类")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Category{
    /**
     * 书籍分类id
     */
    @ApiModelProperty("书籍分类id")
    private Integer id;

    /**
     * 书籍分类名字
     */
    @ApiModelProperty("书籍分类名字")
    private String name;

    /**
     * 书籍分类描述
     */
    @ApiModelProperty("书籍分类描述")
    private String description;

    /**
     * 父分类ID
     */
    @ApiModelProperty("父分类ID")
    private Integer parentId;

}