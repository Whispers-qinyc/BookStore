package com.briup.bookstore.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 
 * @TableName es_shopcar
 */
@ApiModel("购物车实体类")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Shopcar{
    /**
     * 购物车ID
     */
    @ApiModelProperty("购物车ID")
    private Integer id;

    /**
     * 客户ID
     */
    @ApiModelProperty("客户ID")
    private Integer userId;

    /**
     * 书籍ID
     */
    @ApiModelProperty("书籍ID")
    private Integer bookId;

    /**
     * 书籍数量
     */
    @ApiModelProperty("书籍数量")
    private Integer num;
}