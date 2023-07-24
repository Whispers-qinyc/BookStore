package com.briup.bookstore.mapper;

import com.briup.bookstore.dto.UserRegisterDTO;
import com.briup.bookstore.dto.UserStatusUpdateDTO;
import com.briup.bookstore.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
* @author qinyc
* @description 针对表【es_user】的数据库操作Mapper
* @createDate 2023-07-18 21:21:11
* @Entity com.briup.bookstore.po.User
*/
@Repository
public interface UserMapper {

    /**
     * @Author qinyc
     * @Description 根据用户名和密码查询指定用户
     * @Version: v1.0
     * @Date 10:22 2023/7/21
     * @Param :username
     * @Param :password
     * @Return: com.briup.bookstore.po.User
     **/
    User getUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    /**
     * @Author qinyc
     * @Description 查询全部用户，若存在username，根据username模糊查询，若存在status，根据status精确匹配,registerTime作为范围查询
     * @Version: v1.0
     * @Date 10:23 2023/7/21
     * @Param :username
     * @Param :status
     * @Param :registerStartTime
     * @Param :registerEndTime
     * @Return: java.util.List<com.briup.bookstore.po.User>
     **/
    List<User> getAllUserByUsernameOrStatus0rRegisterTime(@Param("username") String username, @Param("status") String status, @Param("registerStartTime") LocalDateTime registerStartTime, @Param("registerEndTime") LocalDateTime registerEndTime);

    /**
     * @Author qinyc
     * @Description 根据用户名查询用户信息条数
     * @Version: v1.0
     * @Date 10:25 2023/7/21
     * @Param :username
     * @Return: int
     **/
    int getCountByUsername(String username);

    /**
     * @Author qinyc
     * @Description 新增用户
     * @Version: v1.0
     * @Date 10:25 2023/7/21
     * @Param :userRegisterDTO
     * @Return: void
     **/
    void insertUser(UserRegisterDTO userRegisterDTO);

    /**
     * @Author qinyc
     * @Description 修改用户状态
     * @Version: v1.0
     * @Date 10:26 2023/7/21
     * @Param :userStatusUpdateDTO
     * @Return: void
     **/
    void updateUserStatus(UserStatusUpdateDTO userStatusUpdateDTO);

    /**
     * @Author qinyc
     * @Description 删除与批量删除用户
     * @Version: v1.0
     * @Date 10:26 2023/7/21
     * @Param :ids
     * @Return: void
     **/
    void deleteBatchIds(@Param("ids") String ids);

    /**
     * @Author qinyc
     * @Description 根据用户ID查询用户信息
     * @Version: v1.0
     * @Date 10:26 2023/7/21
     * @Param :id
     * @Return: com.briup.bookstore.po.User
     **/
    User getUserById(int id);
}




