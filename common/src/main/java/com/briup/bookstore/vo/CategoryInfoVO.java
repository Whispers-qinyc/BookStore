package com.briup.bookstore.vo;

import com.alipay.api.domain.CategoryVO;
import com.briup.bookstore.po.TreeNode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: CategoryParentVO
 * @Description: 分类模型数据
 * @author: qinyc
 * @date: 2023/7/21 10:41
 * @version: v1.0
 */
@ApiModel("父分类模型数据")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CategoryInfoVO extends TreeNode {
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
}
