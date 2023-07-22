package com.briup.bookstore.mapper;

import com.briup.bookstore.po.Category;
import com.briup.bookstore.vo.CategoryInfoVO;
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
    List<CategoryInfoVO> selectAllCategoryByName(String name);

    /**
     * @Author qinyc
     * @Description 查询全部分类信息
     * @Version: v1.0
     * @Date 15:17 2023/7/21
     * @Param :
     * @Return: java.util.List<com.briup.bookstore.po.Category>
     **/
    List<Category> selectAllCategory();

    /**
     * @Author qinyc
     * @Description 根据分类ID获取分类信息
     * @Version: v1.0
     * @Date 15:39 2023/7/21
     * @Param :id
     * @Return: com.briup.bookstore.po.Category
     **/
    Category selectCategoryById(Integer id);

    /**
     * @Author qinyc
     * @Description 新增分类
     * @Version: v1.0
     * @Date 3:56 2023/7/23
     * @Param :category
     * @Return: void
     **/
    void insertCategory(Category category);
}




