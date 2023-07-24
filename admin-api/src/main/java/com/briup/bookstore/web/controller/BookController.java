package com.briup.bookstore.web.controller;

import com.briup.bookstore.po.Book;
import com.briup.bookstore.response.Result;
import com.briup.bookstore.service.BookService;
import com.briup.bookstore.vo.BookSearchVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: BookController
 * @Description: 图书管理模块相关借口开发
 * @Author: songjl
 * @Date: 2023/7/20 09:21
 * @Version: v1.0
 */
@RestController
@Api(tags = "图书模块")
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @ApiOperation("分页多条件查询图书信息")
    @GetMapping("{pageNum}/{pageSize}")
    private Result getPageBook(@PathVariable("pageNum") Integer pageNum,
                               @PathVariable("pageSize") Integer pageSize,
                               BookSearchVO bookSearchVO) {
        return Result.success(bookService.getPageBook(pageNum, pageSize, bookSearchVO));
    }

    @ApiOperation("新增图书信息")
    @PostMapping
    private Result saveBook(@RequestBody Book book) {
        bookService.saveBook(book);
        return Result.success();
    }

    @ApiOperation("修改图书信息")
    @PutMapping
    private Result modifyBook(@RequestBody Book book) {
        bookService.modifyBook(book);
        return Result.success();
    }

    @ApiOperation("修改图书状态")
    @PutMapping("{id}/{status}")
    private Result modifyStatus(@PathVariable Integer id, @PathVariable Integer status) {
        bookService.modifyStatus(id, status);
        return Result.success();
    }

    @ApiOperation("删除图书信息")
    @DeleteMapping("{id}")
    private Result removeBook(@PathVariable Integer id) {
        bookService.removeBook(id);
        return Result.success();
    }

    @ApiOperation("批量删除图书信息")
    @DeleteMapping
    private Result removeBatchByIds(@RequestBody List<Integer> ids) {
        bookService.removeBatchByIds(ids);
        return Result.success();
    }

    @ApiOperation("根据图书id查询图书信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "图书编号", required = true)
    })
    @GetMapping("{id}")
    private Result getBookById(@PathVariable Integer id) {
        return Result.success(bookService.getBookById(id));
    }

}