package com.briup.bookstore.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @className: AdminUpdateUserStatusDTO
 * @Description: 管理系统修改用户状态数据传输对象
 * @author: qinyc
 * @date: 2023/7/19 11:28
 * @version: v1.0
 */
@ApiModel("修改用户状态数据传输对象")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserStatusUpdateDTO {
    /**
     * 主键ID
     */
    @ApiModelProperty("主键ID")
    private Integer id;

    /**
     * 用户状态(0正常，1禁用)
     */
    @ApiModelProperty("用户状态(0正常，1禁用)")
    private Integer status;
}
