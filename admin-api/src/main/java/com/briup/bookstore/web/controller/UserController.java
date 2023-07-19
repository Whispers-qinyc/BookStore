package com.briup.bookstore.web.controller;

import com.briup.bookstore.dto.AdminAddUserDTO;
import com.briup.bookstore.response.Result;
import com.briup.bookstore.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @className: UserController
 * @Description: 用户相关Controller层
 * @author: qinyc
 * @date: 2023/7/19 9:11
 * @version: v1.0
 */
@Api(tags = "用户模块")
@RestController
@RequestMapping("/admin")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @Author qinyc
     * @Description  分页多条件查询用户信息，若存在username，根据username模糊查询，若存在gender，根据gender精确匹配
     * @version: v1.0
     * @Date 9:14 2023/7/19
     **/
    @ApiOperation("分页多条件查询用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum",value = "当前页码",required = true),
            @ApiImplicitParam(name = "pageSize",value = "每页大小",required = true),
            @ApiImplicitParam(name = "username",value = "用户名"),
            @ApiImplicitParam(name = "gender",value = "性别"),
    })
    @GetMapping("/getPageUser")
    public Result getPageUser(Integer pageNum,Integer pageSize,String username,String gender){
        return userService.getPageUser(pageNum,pageSize,username,gender);
    }

    /**
     * @Author qinyc
     * @Description  新增用户信息
     * @version: v1.0
     * @Date 9:56 2023/7/19
     **/
    @ApiOperation("新增用户信息")
    @PostMapping("/addUser")
    public Result addUser(@RequestBody AdminAddUserDTO addUserDTO){
        return userService.addUser(addUserDTO);
    }
}
