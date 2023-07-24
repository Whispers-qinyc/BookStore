package com.briup.bookstore.mapper;

import com.briup.bookstore.po.Log;

/**
* @author qinyc
* @description 针对表【es_log】的数据库操作Mapper
* @createDate 2023-07-23 13:38:30
* @Entity com.briup.bookstore.po.Log
*/
public interface LogMapper {

    /**
     * @Author qinyc
     * @Description 插入日志
     * @Version: v1.0
     * @Date 18:55 2023/7/23
     * @Param :logPO
     * @Return: void
     **/
    void insertLog(Log logPO);
}




