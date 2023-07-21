package com.briup.bookstore.web.controller;

import com.briup.bookstore.response.Result;
import com.briup.bookstore.service.CategoryService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
