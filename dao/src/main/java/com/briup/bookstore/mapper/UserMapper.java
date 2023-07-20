package com.briup.bookstore.mapper;

import com.briup.bookstore.dto.UserRegisterDTO;
import com.briup.bookstore.dto.UserStatusUpdateDTO;
import com.briup.bookstore.po.User;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

/**
* @author qinyc
* @description 针对表【es_user】的数据库操作Mapper
* @createDate 2023-07-18 21:21:11
* @Entity com.briup.bookstore.po.User
*/
public interface UserMapper {

    /**
     * @Author qinyc
     * @Description  根据用户名和密码查询指定用户
     * @version: v1.0
     * @Date 22:37 2023/7/18
     **/
    User getUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    /**
     * @Author qinyc
     * @Description  查询全部用户，若存在username，根据username模糊查询，若存在status，根据status精确匹配,registerTime作为范围查询
     * @version: v1.0
     * @Date 9:28 2023/7/19
     **/
    List<User> getAllUserByUsernameOrStatus0rRegisterTime(@Param("username") String username, @Param("status") String status, @Param("registerStartTime") LocalDateTime registerStartTime, @Param("registerEndTime") LocalDateTime registerEndTime);

    /**
     * @Author qinyc
     * @Description  根据用户名查询用户信息条数
     * @version: v1.0
     * @Date 10:14 2023/7/19
     **/
    int getCountByUsername(String username);

    /**
     * @Author qinyc
     * @Description  新增用户
     * @version: v1.0
     * @Date 10:33 2023/7/19
     **/
    void insertUser(UserRegisterDTO userRegisterDTO);

    /**
     * @Author qinyc
     * @Description  修改用户状态
     * @version: v1.0
     * @Date 13:37 2023/7/19
     **/
    void updateUserStatus(UserStatusUpdateDTO userStatusUpdateDTO);

    /**
     * @Author qinyc
     * @Description  删除与批量删除用户
     * @version: v1.0
     * @Date 14:09 2023/7/19
     **/
    void deleteBatchIds(@Param("ids") String ids);

    /**
     * @Author qinyc
     * @Description  根据用户ID查询用户信息
     * @version: v1.0
     * @Date 15:56 2023/7/19
     **/
    User getUserById(int id);
}




