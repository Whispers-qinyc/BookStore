package com.briup.bookstore.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * @className: AdminAddUserDTO
 * @Description: 管理系统新增用户数据传输对象
 * @author: qinyc
 * @date: 2023/7/19 10:00
 * @version: v1.0
 */
@ApiModel("管理系统新增用户数据传输对象")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserRegisterDTO {
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

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String phone;

    /**
     * 用户头像
     */
    @ApiModelProperty("用户头像")
    private String avatar;

    /**
     * 用户性别(0男，1女)
     */
    @ApiModelProperty("用户性别(0男，1女)")
    private String gender;

    /**
     * 用户生日
     */
    @ApiModelProperty("用户生日")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;


}
