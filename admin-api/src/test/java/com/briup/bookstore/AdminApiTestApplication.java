package com.briup.bookstore;

import com.briup.bookstore.utils.IpUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @className: AdminApiTestApplication
 * @Description:
 * @author: qinyc
 * @date: 2023/7/23 17:54
 * @version: v1.0
 */

@SpringBootTest
public class AdminApiTestApplication {
    /**
     * @Author qinyc
     * @Description 根据Ip获取运营商等信息
     * @Version: v1.0
     * @Date 18:01 2023/7/23
     * @Param :
     * @Return: void
     **/
    @Test
    void ipTest(){
        //获取本机ip基本信息
        System.out.println(IpUtils.getIp(null));
        //获取指定ip基本信息
        System.out.println(IpUtils.getIp("124.222.242.111"));
}
}
