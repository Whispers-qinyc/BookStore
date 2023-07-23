package com.briup.bookstore.web.controller;

import com.briup.bookstore.annotation.SystemLog;
import com.briup.bookstore.dto.UserStatusUpdateDTO;
import com.briup.bookstore.response.Result;
import com.briup.bookstore.service.UserService;
import com.briup.bookstore.vo.UserInfoVO;
import com.briup.bookstore.vo.UserPageVO;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

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
     * @Description 分页多条件查询用户信息，若存在username，根据username模糊查询，若存在gender，根据gender精确匹配
     * @Version: v1.0
     * @Date 10:21 2023/7/21
     * @Param :pageNum
     * @Param :pageSize
     * @Param :username
     * @Param :status
     * @Param :startTime
     * @Param :endTime
     * @Return: com.briup.bookstore.response.Result
     **/
    @SystemLog(businessName = "分页多条件查询用户信息")
    @ApiOperation("分页多条件查询用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum",value = "当前页码",required = true),
            @ApiImplicitParam(name = "pageSize",value = "每页大小",required = true),
            @ApiImplicitParam(name = "username",value = "用户名"),
            @ApiImplicitParam(name = "status",value = "用户状态"),
            @ApiImplicitParam(name = "startTime",value = "开始时间"),
            @ApiImplicitParam(name = "endTime",value = "结束时间"),
    })
    @GetMapping("/getPageUser")
    public Result getUserPage(Integer pageNum, Integer pageSize, String username, String status, String startTime,String endTime){
        PageInfo<UserPageVO>  userPageVOPageInfo = userService.getUserPage(pageNum, pageSize, username, status, startTime, endTime);
        return  Result.success(userPageVOPageInfo);
    }



    /**
     * @Author qinyc
     * @Description 修改用户状态
     * @Version: v1.0
     * @Date 10:23 2023/7/21
     * @Param :userStatusUpdateDTO
     * @Return: com.briup.bookstore.response.Result
     **/
    @SystemLog(businessName = "修改用户状态")
    @ApiOperation("修改用户状态")
    @PutMapping("/updateUserStatus")
    public Result updateUserStatus(@RequestBody UserStatusUpdateDTO userStatusUpdateDTO){
        userService.updateUserStatus(userStatusUpdateDTO);
        return  Result.success();
    }

    /**
     * @Author qinyc
     * @Description 删除与批量删除用户
     * @Version: v1.0
     * @Date 10:23 2023/7/21
     * @Param :ids
     * @Return: com.briup.bookstore.response.Result
     **/
    @SystemLog(businessName = "删除与批量删除用户")
    @ApiOperation("删除与批量删除用户")
    @DeleteMapping("/deleteUser/{ids}")
    public Result deleteUser(@PathVariable("ids") String ids){
        userService.deleteUser(ids);
        return Result.success();
    }


    /**
     * @Author qinyc
     * @Description 获取用户个人信息
     * @Version: v1.0
     * @Date 10:23 2023/7/21
     * @Param :token
     * @Return: com.briup.bookstore.response.Result
     **/
    @SystemLog(businessName = "获取用户个人信息")
    @ApiOperation("获取用户个人信息")
    @GetMapping("/getUserInfo")
    public Result getUserInfo(@RequestHeader("token") @ApiIgnore String token) throws Exception {
        UserInfoVO userInfo = userService.getUserInfo(token);
        return Result.success(userInfo);
    }
}
