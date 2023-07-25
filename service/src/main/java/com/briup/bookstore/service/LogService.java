package com.briup.bookstore.service;


import com.github.pagehelper.PageInfo;

/**
* @author qinyc
* @description 针对表【es_log】的数据库操作Service
* @createDate 2023-07-23 13:38:30
*/
public interface LogService{

    /**
     * @Author qinyc
     * @Description 分页多条件获取日志信息
     * @Version: v1.0
     * @Date 9:11 2023/7/25
     * @Param :pageNum
     * @Param :pageSize
     * @Param :username
     * @Return: com.github.pagehelper.PageInfo
     **/
    PageInfo getLogPage(Integer pageNum, Integer pageSize, String username);
}
