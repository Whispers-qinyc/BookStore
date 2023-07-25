package com.briup.bookstore.web.controller;

import com.briup.bookstore.dto.CategoryAddDTO;
import com.briup.bookstore.dto.CategoryUpdateDTO;
import com.briup.bookstore.po.Category;
import com.briup.bookstore.response.Result;
import com.briup.bookstore.service.CategoryService;
import com.briup.bookstore.vo.CategoryInfoVO;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @className: CategoryController
 * @Description: 后台管理系统分类相关Controller层
 * @author: qinyc
 * @date: 2023/7/20 17:21
 * @version: v1.0
 */
@Api(tags = "分类模块")
@RestController
@RequestMapping("/admin")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * @Author qinyc
     * @Description 分页多条件查询分类信息
     * @Version: v1.0
     * @Date 10:20 2023/7/21
     * @Param :pageNum
     * @Param :pageSize
     * @Param :name
     * @Return: com.briup.bookstore.response.Result
     **/
    @ApiOperation("分页多条件查询分类信息")
    @GetMapping("/getCategoryPage")
    public Result getCategoryPage(Integer pageNum,Integer pageSize,String name){
        PageInfo categoryPageInfo = categoryService.getCategoryPage(pageNum,pageSize,name);
        return Result.success(categoryPageInfo);
    }

    /**
     * @Author qinyc
     * @Description 查询全部分类
     * @Version: v1.0
     * @Date 14:54 2023/7/21
     * @Param : null
     * @Return: com.briup.bookstore.response.Result
     **/
    @ApiOperation("查询全部分类")
    @GetMapping("/getAllCategory")
    public Result getAllCategory(){
        List<CategoryInfoVO> categoryPageVOS =  categoryService.getAllCategory();
        return Result.success(categoryPageVOS);
    }

    /**
     * @Author qinyc
     * @Description 根据分类ID获取分类信息
     * @Version: v1.0
     * @Date 15:31 2023/7/21
     * @Param :id
     * @Return: com.briup.bookstore.response.Result
     **/
    @ApiOperation("根据分类ID获取分类信息")
    @GetMapping("/getCategoryById/{id}")
    public Result getCategoryById(@PathVariable("id") Integer id){
        Category category = categoryService.getCategoryById(id);
        return Result.success(category);
    }

    /**
     * @Author qinyc
     * @Description 新增分类
     * @Version: v1.0
     * @Date 3:50 2023/7/23
     * @Param :categoryAddDTO
     * @Return: com.briup.bookstore.response.Result
     **/
    @ApiOperation("新增分类")
    @PostMapping("/addCategory")
    public Result addCategory(@RequestBody CategoryAddDTO categoryAddDTO){
        categoryService.addCategory(categoryAddDTO);
        return Result.success();
    }


    /**
     * @Author qinyc
     * @Description 修改分类
     * @Version: v1.0
     * @Date 4:14 2023/7/23
     * @Param :categoryUpdateDTO
     * @Return: com.briup.bookstore.response.Result
     **/
    @ApiOperation("修改分类")
    @PutMapping("/updateCategory")
    public Result updateCategory(@RequestBody CategoryUpdateDTO categoryUpdateDTO){
        categoryService.updateCategory(categoryUpdateDTO);
        return Result.success();
    }

    /**
     * @Author qinyc
     * @Description 删除分类信息(删除+批量删除)
     * @Version: v1.0
     * @Date 4:34 2023/7/23
     * @Param :ids
     * @Return: com.briup.bookstore.response.Result
     **/
    @ApiOperation("删除分类信息")
    @DeleteMapping("/deleteCategory/{ids}")
    public Result deleteCategory(@PathVariable("ids") String ids){
        categoryService.deleteCategory(ids);
        return Result.success();
    }
}
