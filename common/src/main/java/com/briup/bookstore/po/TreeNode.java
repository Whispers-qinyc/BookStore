package com.briup.bookstore.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.ArrayList;
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
     * id
     */
    @ApiModelProperty("id")
    public Integer id;

    /**
     * 父ID
     */
    @ApiModelProperty("父ID")
    public Integer parentId;

    /**
     * 子信息
     */
    @ApiModelProperty("子信息")
    private List children = new ArrayList<>();
}
