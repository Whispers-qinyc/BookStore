package com.briup.bookstore.po;

import com.briup.bookstore.vo.CategoryPageVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @className: TreeNode
 * @Description: 树状结构数据基础类
 * @author: qinyc
 * @date: 2023/7/21 14:09
 * @version: v1.0
 */
@ApiModel("树状结构数据基础类")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class TreeNode {
    /**
     * 书籍分类id
     */
    @ApiModelProperty("书籍分类id")
    public Integer id;

    /**
     * 父分类ID
     */
    @ApiModelProperty("父分类ID")
    public Integer parentId;
}
