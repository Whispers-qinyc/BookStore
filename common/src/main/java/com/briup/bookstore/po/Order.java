package com.briup.bookstore.po;


import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 
 * @TableName es_order
 */
@ApiModel("订单实体")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Order {
    /**
     * 订单编号
     */
    @ApiModelProperty("订单编号")
    private Integer id;

    /**
     * 下单用户
     */
    @ApiModelProperty("下单用户")
    private Integer userId;

    /**
     * 收货地址
     */
    @ApiModelProperty("收货地址")
    private Integer addressId;

    /**
     * 创建订单时间
     */
    @ApiModelProperty("创建订单时间")
    private LocalDateTime createDate;

    /**
     * 支付方式
     */
    @ApiModelProperty("支付方式")
    private String payWay;

    /**
     * 快递单号
     */
    @ApiModelProperty("快递单号")
    private Integer trackingNumber;

    /**
     * 配送方式
     */
    @ApiModelProperty("配送方式")
    private String distributionMode;

    /**
     * 订单状态
     * 1.已创建未支付
     * 2.已支付未发货
     * 3.已发货未收货
     * 4.已收货
     * 5.已关闭 只能关闭 已创建未支付的订单
     */
    @ApiModelProperty("订单状态 1.已创建未支付 2.已支付未发货 3.已发货未收货 4.已收货 5.已关闭 只能关闭 已创建未支付的订单")
    private Integer status;

    /**
     * 支付时间
     */
    @ApiModelProperty("支付时间")
    private LocalDateTime payDate;
}