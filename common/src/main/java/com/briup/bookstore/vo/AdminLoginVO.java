package com.briup.bookstore.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @className: AdminLoginVO
 * @Description: 后台登录接口模型数据
 * @author: qinyc
 * @date: 2023/7/19 16:12
 * @version: v1.0
 */
@ApiModel("用户个人信息模型数据（登录）")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class AdminLoginVO {
    /**
     * 令牌
     **/
    @ApiModelProperty("jwt令牌")
    private String jwt;

   /**
    * 登录用户信息
    **/
   @ApiModelProperty("登录用户信息")
    private UserInfoVO userInfo;
}
