package com.briup.bookstore.po;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 
 * @TableName es_log
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Log {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 操作用户
     */
    private String username;

    /**
     *
     */
    private String businessName;

    /**
     * 请求接口
     */
    private String requestUrl;

    /**
     * 请求方式
     */
    private String requestMethod;

    /**
     * 系统名称
     */
    private String operationName;

    /**
     * 浏览器名称
     */
    private String browserName;

    /**
     * ip
     */
    private String ip;

    /**
     * ip来源
     */
    private String source;

    /**
     * 请求接口耗时
     */
    private Long spendTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 请求参数
     */
    private String paramsJson;

    /**
     * 类地址
     */
    private String classPath;

    /**
     * 方法名
     */
    private String methodName;
}