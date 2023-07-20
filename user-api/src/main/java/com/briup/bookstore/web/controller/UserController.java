package com.briup.bookstore.web.controller;

import com.briup.bookstore.response.Result;
import com.briup.bookstore.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("user")
public class UserController {
    @Resource
    private UserService   userService;

    @PostMapping("login")
    public Result login(UserLoginDto){
        userService.adminLogin()

        return Result.success();
    }
}
