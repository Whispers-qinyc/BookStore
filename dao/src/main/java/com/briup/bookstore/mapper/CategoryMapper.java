package com.briup.bookstore.mapper;

import com.briup.bookstore.po.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author qinyc
* @description 针对表【es_category】的数据库操作Mapper
* @createDate 2023-07-18 21:32:43
* @Entity com.briup.bookstore.po.Category
*/
@Repository
public interface CategoryMapper {

    /**
     * @Author qinyc
     * @Description  查询所有分类信息，如果存在分类名称，根据分类名称模糊匹配全部数据
     * @Version: v1.0
     * @Date 10:34 2023/7/21
     * @Param :name
     * @Return: java.util.List<com.briup.bookstore.po.Category>
     **/
    List<Category> selectAllCategoryByName(String name);

    /**
     * @Author qinyc
     * @Description 查询全部分类信息
     * @Version: v1.0
     * @Date 15:17 2023/7/21
     * @Param :
     * @Return: java.util.List<com.briup.bookstore.po.Category>
     **/
    List<Category> selectAllCategory();
}




