package com.briup.bookstore.utils;

import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @className: BeanCopyUtils
 * @Description: Bean拷贝工具类
 * @author: qinyc
 * @date: 2023/7/19 9:38
 * @version: v1.0
 */

public class BeanCopyUtils {
    /**
     * @Author qinyc
     * @Description  bean--->vo（单个对象的转换）
     * @version: v1.0
     * @Date 9:39 2023/7/19
     * @Param source：原本的bean对象，clazz：vo的类对象
     * @return V：赋值以后的的vo对象
     **/
    public static <V> V copyBean(Object source,Class<V> clazz) {
        //目标对象的声明
        V target = null;
        try {
            //创建目标对象
            target = clazz.newInstance();
            //实现属性拷贝
            BeanUtils.copyProperties(source, target);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        //返回目标对象
        return target;
    }



    /**
     * @Author qinyc
     * @Description  bean--->vo（多个对象的转换）
     * @version: v1.0
     * @Date 9:45 2023/7/19
     * @Param sourceList：原本存放bean对象的集合，clazz：vo的类对象
     * @return List<V>：复制以后的存放vo对象的集合
     **/
    public static <S,V> List<V> copyBeanList(List<S> sourceList, Class<V> clazz){
        //返回vo的list集合
        return sourceList.stream()
                .map(source -> copyBean(source,clazz))
                .collect(Collectors.toList());
    }
}
