package com.briup.bookstore.web.controller;

import com.briup.bookstore.constant.BookStoreConstant;
import com.briup.bookstore.dto.UserLoginDTO;
import com.briup.bookstore.response.Result;
import com.briup.bookstore.service.UserService;
import com.briup.bookstore.vo.UserLoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: AdminLoginController
 * @Description: 后台管理系统登录相关Controller层
 * @author: qinyc
 * @date: 2023/7/18 22:19
 * @version: v1.0
 */

@Api(tags = "登录相关模块")
@RestController
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * @Author qinyc
     * @Description 登录
     * @Version: v1.0
     * @Date 10:21 2023/7/21
     * @Param :userLoginDTO
     * @Param :roleId
     * @Return: com.briup.bookstore.response.Result
     **/
    @ApiOperation("登录")
    @PostMapping("/login")
    public Result adminLogin(@RequestBody UserLoginDTO userLoginDTO){
        UserLoginVO login = userService.login(userLoginDTO, BookStoreConstant.LOGIN_ADMIN);
        return Result.success(login);
    }

}
