package com.briup.bookstore.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @className: AdminLoginDTO
 * @Description: 管理员端登录数据传输对象
 * @author: qinyc
 * @date: 2023/7/18 22:25
 * @version: v1.0
 */
@ApiModel("用户登录数据传输对象")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserLoginDTO {
    /**
     * 登录用户名
     */
    @ApiModelProperty("登录用户名")
    private String username;

    /**
     * 登录密码
     */
    @ApiModelProperty("登录密码")
    private String password;
}
