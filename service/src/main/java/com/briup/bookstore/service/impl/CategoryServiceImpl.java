package com.briup.bookstore.service.impl;

import com.briup.bookstore.dto.CategoryAddDTO;
import com.briup.bookstore.dto.CategoryUpdateDTO;
import com.briup.bookstore.exception.BookStoreException;
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
import java.util.Objects;

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
     * @Description 分页多条件查询分类信息(一对多实现)
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
//        //核心查询
//        List<Category> categories =  categoryMapper.selectAllCategoryByName(name);
//        //Bean拷贝
//        List<CategoryInfoVO> categoryInfoVOS = BeanCopyUtils.copyBeanList(categories, CategoryInfoVO.class);
//        //扁平化数据转换树状数据
//        categoryInfoVOS = TreeDataUtils.convert(categoryInfoVOS);
//        //将查询出来的分类集合封装在CategoryPageVO对象中
//        PageInfo<CategoryInfoVO> categoryInfoVOPageInfo = new PageInfo<>(categoryInfoVOS);
//        //返回PageInfo对象
//        return categoryInfoVOPageInfo;
        List<CategoryInfoVO> categoryInfoVOS =  categoryMapper.selectAllCategoryByName(name);
        PageInfo<CategoryInfoVO> categoryInfoVOPageInfo = new PageInfo<>(categoryInfoVOS);
        return categoryInfoVOPageInfo;
    }

    /**
     * @Author qinyc
     * @Description 查询全部分类（扁平化数据转树状数据）
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

    /**
     * @Author qinyc
     * @Description 新增分类
     * @Version: v1.0
     * @Date 3:52 2023/7/23
     * @Param :categoryAddDTO
     * @Return: void
     **/
    @Override
    public void addCategory(CategoryAddDTO categoryAddDTO) {
        //查询所有分类列表
        List<Category> categories = categoryMapper.selectAllCategory();
        //遍历全部分类
        for (Category category : categories) {
            //对比即将新增的分类名称是否已经存在
            if (category.getName().equals(categoryAddDTO.getName())){
                //分类名称已经存在
                throw new BookStoreException(BookStoreException.CodeMsgEnum.CATEGORY_NAME_IS_EXIST);
            }
        }
        //Bean拷贝
        Category category = BeanCopyUtils.copyBean(categoryAddDTO, Category.class);
        //新增分类
        categoryMapper.insertCategory(category);
    }


    /**
     * @Author qinyc
     * @Description 修改分类
     * @Version: v1.0
     * @Date 4:16 2023/7/23
     * @Param :categoryUpdateDTO
     * @Return: void
     **/
    @Override
    public void updateCategory(CategoryUpdateDTO categoryUpdateDTO) {
        //判断待更新的分类信息是否存在
        if (Objects.isNull(categoryMapper.selectCategoryById(categoryUpdateDTO.getId()))){
            //指定的分类信息不存在
            throw new BookStoreException(BookStoreException.CodeMsgEnum.CATEGORY_IS_NOT_EXIST);
        }
        //查询全部分类信息
        List<Category> categories = categoryMapper.selectAllCategory();
        //遍历查询出来的分类集合
        for (Category category : categories) {
            if (category.getId() != categoryUpdateDTO.getId() && category.getName().equals(categoryUpdateDTO.getName())){
                //分类名称已经存在
                throw new BookStoreException(BookStoreException.CodeMsgEnum.CATEGORY_NAME_IS_EXIST);
            }
        }
        //Bean拷贝
        Category category = BeanCopyUtils.copyBean(categoryUpdateDTO, Category.class);
        //根据分类ID更新分类信息
        categoryMapper.updateCategoryById(category);
    }
}




