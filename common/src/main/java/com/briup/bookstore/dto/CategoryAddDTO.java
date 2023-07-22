package com.briup.bookstore.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @className: CategoryAddDTO
 * @Description: 新增分类数据传输对象
 * @author: qinyc
 * @date: 2023/7/23 3:48
 * @version: v1.0
 */
@ApiModel("新增分类数据传输对象")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CategoryAddDTO {
    /**
     * 书籍分类名字
     */
    @ApiModelProperty("书籍分类名字")
    private String name;

    /**
     * 书籍分类描述
     */
    @ApiModelProperty("书籍分类描述")
    private String description;

    /**
     * 父分类ID
     */
    @ApiModelProperty("父分类ID")
    private Integer parentId;
}
