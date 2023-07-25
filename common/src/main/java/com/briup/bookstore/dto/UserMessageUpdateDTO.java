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
 * @Author briup-adam
 * @Date 2023/7/25 上午9:05
 * @Description
 **/

@ApiModel("用户信息修改传输对象")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserMessageUpdateDTO {
    /**
     * 用户ID
     */
    @ApiModelProperty("用户ID")
    private  Integer id;
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
