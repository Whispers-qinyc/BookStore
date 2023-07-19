package com.briup.bookstore.po;

import java.time.LocalDate;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 
 * @TableName es_user
 */
@ApiModel("用户实体类")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class User {
    /**
     * 主键ID
     */
    @ApiModelProperty("主键ID")
    private Integer id;

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
     * 用户状态(0正常，1禁用)
     */
    @ApiModelProperty("用户状态(0正常，1禁用)")
    private Integer status;

    /**
     * 用户生日
     */
    @ApiModelProperty("用户生日")
    private LocalDate birthday;

    /**
     * 注册时间
     */
    @ApiModelProperty("注册时间")
    private LocalDateTime registerTime;

    /**
     * 角色编号 1. 管理员 2. 普通用户
     */
    @ApiModelProperty("角色编号 1. 管理员 2. 普通用户")
    private Integer roleId;

    /**
     * 用户是否开通会员
     */
    @ApiModelProperty("用户是否开通会员")
    private Boolean isVip;

    /**
     * 用户会员到期时间
     */
    @ApiModelProperty("用户会员到期时间")
    private LocalDateTime vipExpirationTime;
}