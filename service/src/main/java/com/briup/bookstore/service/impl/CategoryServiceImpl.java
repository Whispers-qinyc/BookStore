package com.briup.bookstore.service.impl;

import com.briup.bookstore.mapper.CategoryMapper;
import com.briup.bookstore.po.Category;
import com.briup.bookstore.service.CategoryService;
import com.briup.bookstore.utils.BeanCopyUtils;
import com.briup.bookstore.utils.TreeDataUtils;
import com.briup.bookstore.vo.CategoryPageVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author qinyc
* @description 针对表【es_category】的数据库操作Service实现
* @createDate 2023-07-18 21:32:43
*/
@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * @Author qinyc
     * @Description 分页多条件查询分类信息
     * @Version: v1.0
     * @Date 10:27 2023/7/21
     * @Param :pageNum
     * @Param :pageSize
     * @Param :name
     * @Return: com.github.pagehelper.PageInfo
     **/
    @Override
    public PageInfo getCategoryPage(Integer pageNum, Integer pageSize, String name) {
        //开启PageHelper分页插件
        PageHelper.startPage(pageNum,pageSize,true);
        //核心查询
        List<Category> categories =  categoryMapper.selectAllCategoryByName(name);
        List<CategoryPageVO> categoryPageVOS = BeanCopyUtils.copyBeanList(categories, CategoryPageVO.class);
        List<CategoryPageVO> convert = TreeDataUtils.convert(categoryPageVOS);
        //将查询出来的分类集合封装在CategoryPageVO对象中
        PageInfo<CategoryPageVO> categoryPageVOPageInfo = new PageInfo<>(convert);
        return categoryPageVOPageInfo;
    }
}




