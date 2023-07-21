package com.briup.bookstore.web.controller;

import com.briup.bookstore.service.CategoryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
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
}
