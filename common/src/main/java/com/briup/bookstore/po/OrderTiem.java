package com.briup.bookstore.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 
 * @TableName es_order_tiem
 */
@ApiModel("订单项实体")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class OrderTiem{
    /**
     * 订单项编号
     */
    @ApiModelProperty("订单项编号")
    private Integer id;

    /**
     * 所属订单
     */
    @ApiModelProperty("所属订单")
    private Integer orderId;

    /**
     * 包含书籍
     */
    @ApiModelProperty("包含书籍")
    private Integer bookId;

    /**
     * 选购数量
     */
    @ApiModelProperty("选购数量")
    private Integer num;
}