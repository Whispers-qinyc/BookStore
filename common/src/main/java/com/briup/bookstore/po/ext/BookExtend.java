package com.briup.bookstore.po.ext;

import com.briup.bookstore.po.Book;
import com.briup.bookstore.po.Category;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @ClassName: BookExtend
 * @Description: 图书拓展类
 * @Author: songjl
 * @Date: 2023/7/23 22:27
 * @Version: v1.0
 */
@EqualsAndHashCode(callSuper = true)
@ApiModel("图书拓展类")
@Data
public class BookExtend extends Book {

    @ApiModelProperty("图书所属分类")
    private Category category;
}
