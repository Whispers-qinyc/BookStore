package com.briup.bookstore.web.controller;

import com.briup.bookstore.response.Result;
import com.briup.bookstore.service.LogService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: LogController
 * @Description: 日志相关Controller
 * @author: qinyc
 * @date: 2023/7/23 12:09
 * @version: v1.0
 */
@Api(tags = "日志模块")
@RestController
@RequestMapping("/admin")
public class LogController {
    @Autowired
    private LogService logService;

    /**
     * @Author qinyc
     * @Description 分页多条件获取日志信息
     * @Version: v1.0
     * @Date 23:38 2023/7/23
     * @Param :pageNum
     * @Param :pageSize
     * @Param :username
     * @Return: com.briup.bookstore.response.Result
     **/
    @GetMapping("/getLogPage")
    @ApiOperation("分页多条件获取日志信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum",value = "当前页码"),
            @ApiImplicitParam(name = "pageSize",value = "每页大小"),
            @ApiImplicitParam(name = "username",value = "用户名")
    })
    public Result getLogPage(Integer pageNum,Integer pageSize,String username){
        PageInfo pageInfo = logService.getLogPage(pageNum,pageSize,username);
        return Result.success(pageInfo);
    }
}
