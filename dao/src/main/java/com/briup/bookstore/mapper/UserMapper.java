package com.briup.bookstore.mapper;

import com.briup.bookstore.po.User;
import org.apache.ibatis.annotations.Param;

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
     * @Description  查询全部用户，若存在username，根据username模糊查询，若存在gender，根据gender精确匹配
     * @version: v1.0
     * @Date 9:28 2023/7/19
     **/
    List<User> getAllUserByUsernameOrGender(@Param("username") String username, @Param("gender") String gender);

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
     * @Date 10:19 2023/7/19
     **/
    void insertUser(User user);
}




