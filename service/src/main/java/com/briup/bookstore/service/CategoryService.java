package com.briup.bookstore.service;

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
}
