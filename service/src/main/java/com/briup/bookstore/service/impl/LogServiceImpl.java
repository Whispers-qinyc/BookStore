package com.briup.bookstore.service.impl;


import com.briup.bookstore.mapper.LogMapper;
import com.briup.bookstore.po.Log;
import com.briup.bookstore.service.LogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author qinyc
* @description 针对表【es_log】的数据库操作Service实现
* @createDate 2023-07-23 13:38:30
*/
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    /**
     * @Author qinyc
     * @Description 分页多条件获取日志信息
     * @Version: v1.0
     * @Date 9:12 2023/7/25
     * @Param :pageNum
     * @Param :pageSize
     * @Param :username
     * @Return: com.github.pagehelper.PageInfo
     **/
    @Override
    public PageInfo getLogPage(Integer pageNum, Integer pageSize, String username) {
        //开启PageHelper分页插件
        PageHelper.startPage(pageNum,pageSize);
        //核心查询
        List<Log> logs =  logMapper.selectAllLogByUsername(username);
        //将查询出来的数据封装在PageInfo对象中
        PageInfo<Log> logPageInfo = new PageInfo<>(logs);
        return logPageInfo;
    }
}




