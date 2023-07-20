package com.briup.bookstore.web.controller;

import com.briup.bookstore.dto.UserLoginDTO;
import com.briup.bookstore.dto.UserRegisterDTO;
import com.briup.bookstore.response.Result;
import com.briup.bookstore.service.UserService;
import com.briup.bookstore.vo.UserLoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author briup-adam
 * @Date 2023/7/20 下午2:18
 * @Description  用户业务模块
 **/


@RestController
@Api("用户模块")
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService   userService;


    @PostMapping("/login")
    @ApiOperation("用户登录")
    public Result login(@RequestBody UserLoginDTO userLoginDTO){
        UserLoginVO userLoginVO = userService.login(userLoginDTO, 1);
        return Result.success(userLoginVO);
    }
    @PostMapping("/register")
    @ApiOperation("新用户注册")
    public Result register(@RequestBody UserRegisterDTO userRegisterDTO){
        userService.register(userRegisterDTO);
        return Result.success();
    }
}
