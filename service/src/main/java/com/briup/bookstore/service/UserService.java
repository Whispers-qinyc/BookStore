package com.briup.bookstore.service;

import com.briup.bookstore.dto.AdminAddUserDTO;
import com.briup.bookstore.dto.AdminLoginDTO;
import com.briup.bookstore.dto.AdminUpdateUserStatusDTO;
import com.briup.bookstore.dto.UserLoginDTO;
import com.briup.bookstore.dto.UserRegisterDTO;
import com.briup.bookstore.dto.UserStatusUpdateDTO;
import com.briup.bookstore.response.Result;

/**
* @author qinyc
* @description 针对表【es_user】的数据库操作Service
* @createDate 2023-07-18 21:21:11
*/
public interface UserService{

    /**
     * @Author qinyc
     * @Description  登录
     * @version: v1.0
     * @Date 22:31 2023/7/18
     **/
    Result adminLogin(UserLoginDTO adminLoginDTO);

    /**
     * @Author qinyc
     * @Description  分页多条件查询用户信息，若存在username，根据username模糊查询，若存在gender，根据gender精确匹配
     * @version: v1.0
     * @Date 9:22 2023/7/19
     **/
    Result getPageUser(Integer pageNum, Integer pageSize, String username, String status, String startTime, String endTime);

    /**
     * @Author qinyc
     * @Description  新增用户信息
     * @version: v1.0
     * @Date 10:05 2023/7/19
     **/
    Result addUser(UserRegisterDTO userRegisterDTO);

    /**
     * @Author qinyc
     * @Description  修改用户状态
     * @version: v1.0
     * @Date 11:32 2023/7/19
     **/
    Result updateUserStatus(UserStatusUpdateDTO userStatusUpdateDTO);

    /**
     * @Author qinyc
     * @Description  删除与批量删除用户
     * @version: v1.0
     * @Date 14:05 2023/7/19
     **/
    Result deleteUser(String ids);

    /**
     * @Author qinyc
     * @Description  获取用户个人信息
     * @version: v1.0
     * @Date 15:48 2023/7/19
     **/
    Result getUserInfo(String token) throws Exception;
}
