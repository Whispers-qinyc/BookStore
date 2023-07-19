package com.briup.bookstore.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 
 * @TableName es_address
 */
@ApiModel("收货地址实体类")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Address {
    /**
     * 收货地址ID
     */
    @ApiModelProperty("收货地址ID")
    private Integer id;

    /**
     * 收件人姓名
     */
    @ApiModelProperty("收件人姓名")
    private String receiverName;

    /**
     * 省市区地址
     */
    @ApiModelProperty("省市区地址")
    private String urbanAddr;

    /**
     * 详细地址
     */
    @ApiModelProperty("详细地址")
    private String detailAddr;

    /**
     * 收件人电话
     */
    @ApiModelProperty("收件人电话")
    private String phone;

    /**
     * 下单客户ID
     */
    @ApiModelProperty("下单客户ID")
    private Integer userId;

}