package com.briup.bookstore.service.impl;

import com.briup.bookstore.mapper.CategoryMapper;
import com.briup.bookstore.po.Category;
import com.briup.bookstore.service.CategoryService;
import com.briup.bookstore.utils.BeanCopyUtils;
import com.briup.bookstore.utils.TreeDataUtils;
import com.briup.bookstore.vo.CategoryInfoVO;
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
        PageHelper.startPage(pageNum,pageSize);
        //核心查询
        List<Category> categories =  categoryMapper.selectAllCategoryByName(name);
        //Bean拷贝
        List<CategoryInfoVO> categoryInfoVOS = BeanCopyUtils.copyBeanList(categories, CategoryInfoVO.class);
        //扁平化数据转换树状数据
        categoryInfoVOS = TreeDataUtils.convert(categoryInfoVOS);
        //将查询出来的分类集合封装在CategoryPageVO对象中
        PageInfo<CategoryInfoVO> categoryInfoVOPageInfo = new PageInfo<>(categoryInfoVOS);
        //返回PageInfo对象
        return categoryInfoVOPageInfo;
    }

    /**
     * @Author qinyc
     * @Description 查询全部分类
     * @Version: v1.0
     * @Date 15:17 2023/7/21
     * @Param :
     * @Return: java.util.List<com.briup.bookstore.vo.CategoryInfoVO>
     **/
    @Override
    public List<CategoryInfoVO> getAllCategory() {
        //查询全部分类信息
        List<Category> categories = categoryMapper.selectAllCategory();
        //Bean拷贝
        List<CategoryInfoVO> categoryInfoVOS = BeanCopyUtils.copyBeanList(categories, CategoryInfoVO.class);
        //扁平化数据转换树状数据
        categoryInfoVOS = TreeDataUtils.convert(categoryInfoVOS);
        //返回封装好的是树状数据
        return categoryInfoVOS;
    }

    /**
     * @Author qinyc
     * @Description 根据分类ID获取分类信息
     * @Version: v1.0
     * @Date 15:36 2023/7/21
     * @Param :id
     * @Return: com.briup.bookstore.po.Category
     **/
    @Override
    public Category getCategoryById(Integer id) {
        //根据分类ID获取分类信息
        Category category = categoryMapper.selectCategoryById(id);
        //返回查询到的分类对象
        return category;
    }
}




