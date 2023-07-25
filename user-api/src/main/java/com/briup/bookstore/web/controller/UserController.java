package com.briup.bookstore.web.controller;

import com.briup.bookstore.constant.BookStoreConstant;
import com.briup.bookstore.dto.UserLoginDTO;
import com.briup.bookstore.dto.UserMessageUpdateDTO;
import com.briup.bookstore.dto.UserRegisterDTO;
import com.briup.bookstore.response.Result;
import com.briup.bookstore.service.UserService;
import com.briup.bookstore.vo.UserInfoVO;
import com.briup.bookstore.vo.UserLoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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
        UserLoginVO userLoginVO = userService.login(userLoginDTO, BookStoreConstant.LOGIN_USER);
        return Result.success(userLoginVO);
    }
    @PostMapping("/register")
    @ApiOperation("新用户注册")
    public Result register(@RequestBody UserRegisterDTO userRegisterDTO){
        userService.register(userRegisterDTO);
        return Result.success();
    }
    @PutMapping("/updateUser")
    @ApiOperation("用户信息修改")
        public Result updateUser(@RequestBody UserMessageUpdateDTO userMessageUpdateDTO){
        UserInfoVO userMessage = userService.updateUserMessage(userMessageUpdateDTO);
        return Result.success(userMessage);
    }
    @GetMapping("/getUserInfo/{id}")
    @ApiOperation("获取用户详细信息")
    public  Result getUserInfo(@PathVariable String id){
        UserInfoVO vo = userService.getUserInfo(id);
       return Result.success(vo);
    }
}
