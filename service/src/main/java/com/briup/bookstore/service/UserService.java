package com.briup.bookstore.service;


import com.briup.bookstore.dto.UserLoginDTO;
import com.briup.bookstore.dto.UserMessageUpdateDTO;
import com.briup.bookstore.dto.UserRegisterDTO;
import com.briup.bookstore.dto.UserStatusUpdateDTO;
import com.briup.bookstore.vo.UserInfoVO;
import com.briup.bookstore.vo.UserLoginVO;
import com.briup.bookstore.vo.UserPageVO;
import com.github.pagehelper.PageInfo;

/**
* @author qinyc
* @description 针对表【es_user】的数据库操作Service
* @createDate 2023-07-18 21:21:11
*/
public interface UserService{

    /**
     * @Author qinyc
     * @Description 登录
     * @Version: v1.0
     * @Date 10:21 2023/7/21
     * @Param :adminLoginDTO
     * @Param :roleId
     * @Return: com.briup.bookstore.vo.UserLoginVO
     **/
    UserLoginVO login(UserLoginDTO adminLoginDTO, Integer roleId);

    /**
     * @Author qinyc
     * @Description 分页多条件查询用户信息，若存在username，根据username模糊查询，若存在gender，根据gender精确匹配
     * @Version: v1.0
     * @Date 10:22 2023/7/21
     * @Param :pageNum
     * @Param :pageSize
     * @Param :username
     * @Param :status
     * @Param :startTime
     * @Param :endTime
     * @Return: com.github.pagehelper.PageInfo<com.briup.bookstore.vo.UserPageVO>
     **/
    PageInfo<UserPageVO> getUserPage(Integer pageNum, Integer pageSize, String username, String status, String startTime, String endTime);

    /**
     * @Author qinyc
     * @Description 新增用户信息
     * @Version: v1.0
     * @Date 10:24 2023/7/21
     * @Param :userRegisterDTO
     * @Return: void
     **/
    void register(UserRegisterDTO userRegisterDTO);

    /**
     * @Author qinyc
     * @Description 修改用户状态
     * @Version: v1.0
     * @Date 10:24 2023/7/21
     * @Param :userStatusUpdateDTO
     * @Return: void
     **/
    void updateUserStatus(UserStatusUpdateDTO userStatusUpdateDTO);

    /**
     * @Author qinyc
     * @Description 删除与批量删除用户
     * @Version: v1.0
     * @Date 10:24 2023/7/21
     * @Param :ids
     * @Return: void
     **/
    void deleteUser(String ids);

    /**
     * @Author qinyc
     * @Description 获取用户个人信息
     * @Version: v1.0
     * @Date 10:24 2023/7/21
     * @Param :token
     * @Return: com.briup.bookstore.vo.UserInfoVO
     **/
    UserInfoVO getUserInfo(String id) ;

    /**
     * @Author adam
     * @param userMessageUpdateDTO 用户信息修改实体
     * @Date 2023/7/25
     */
    void updateUserMessage(UserMessageUpdateDTO userMessageUpdateDTO);
}
