package com.briup.bookstore.service;

import com.briup.bookstore.dto.AdminAddUserDTO;
import com.briup.bookstore.dto.AdminLoginDTO;
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
    Result adminLogin(AdminLoginDTO adminLoginDTO);

    /**
     * @Author qinyc
     * @Description  分页多条件查询用户信息，若存在username，根据username模糊查询，若存在gender，根据gender精确匹配
     * @version: v1.0
     * @Date 9:22 2023/7/19
     **/
    Result getPageUser(Integer pageNum, Integer pageSize, String username, String gender);

    /**
     * @Author qinyc
     * @Description  新增用户信息
     * @version: v1.0
     * @Date 10:05 2023/7/19
     **/
    Result addUser(AdminAddUserDTO addUserDTO);
}
