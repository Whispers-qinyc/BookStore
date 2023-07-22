package com.briup.bookstore.service;

import com.briup.bookstore.dto.CategoryAddDTO;
import com.briup.bookstore.dto.CategoryUpdateDTO;
import com.briup.bookstore.po.Category;
import com.briup.bookstore.vo.CategoryInfoVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
* @author qinyc
* @description 针对表【es_category】的数据库操作Service
* @createDate 2023-07-18 21:32:43
*/
public interface CategoryService {

    /**
     * @Author qinyc
     * @Description 分页多条件查询分类信息
     * @Version: v1.0
     * @Date 10:26 2023/7/21
     * @Param :pageNum
     * @Param :pageSize
     * @Param :name
     * @Return: com.github.pagehelper.PageInfo
     **/
    PageInfo getCategoryPage(Integer pageNum, Integer pageSize, String name);


    /**
     * @Author qinyc
     * @Description 查询全部分类
     * @Version: v1.0
     * @Date 14:58 2023/7/21
     * @Param :
     * @Return: java.util.List<com.briup.bookstore.vo.CategoryInfoVO>
     **/
    List<CategoryInfoVO> getAllCategory();

    /**
     * @Author qinyc
     * @Description 根据分类ID获取分类信息
     * @Version: v1.0
     * @Date 15:36 2023/7/21
     * @Param :id
     * @Return: com.briup.bookstore.po.Category
     **/
    Category getCategoryById(Integer id);

    /**
     * @Author qinyc
     * @Description 新增分类
     * @Version: v1.0
     * @Date 3:51 2023/7/23
     * @Param :categoryAddDTO
     * @Return: void
     **/
    void addCategory(CategoryAddDTO categoryAddDTO);

    /**
     * @Author qinyc
     * @Description 修改分类
     * @Version: v1.0
     * @Date 4:16 2023/7/23
     * @Param :categoryUpdateDTO
     * @Return: void
     **/
    void updateCategory(CategoryUpdateDTO categoryUpdateDTO);
}
