package com.briup.bookstore.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @className: Ip
 * @Description: ip实体类
 * @author: qinyc
 * @date: 2023/7/23 17:40
 * @version: v1.0
 */
@ApiModel("ip实体类")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Ip {
    /**
     * IP地址
     */
    @ApiModelProperty("IP地址")
    private String ip;

    /**
     * 省
     */
    @ApiModelProperty("省省")
    private String pro;

    /**
     * 省编码
     */
    @ApiModelProperty("省编码")
    private String proCode;

    /**
     * 城市
     */
    @ApiModelProperty("城市")
    private String city;

    /**
     * 城市编码
     */
    @ApiModelProperty("城市编码")
    private String cityCode;

    /**
     * 区
     */
    @ApiModelProperty("区")
    private String region;

    /**
     * 区编码
     */
    @ApiModelProperty("区编码")
    private String regionCode;

    /**
     * 详细地址 + 运营商
     */
    @ApiModelProperty("详细地址 + 运营商")
    private String addr;


    /*
     * 主要用于接参，无实际意义
     */
    private String regionNames;
    private String err;
}
