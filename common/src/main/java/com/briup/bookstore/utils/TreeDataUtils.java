package com.briup.bookstore.utils;

import com.briup.bookstore.vo.CategoryPageVO;
import com.google.common.collect.Lists;
import io.jsonwebtoken.lang.Collections;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @className: TreeDataUtils
 * @Description: 扁平化数据转换成树状结构数据工具类(分类模块专用)
 * @author: qinyc
 * @date: 2023/7/21 11:04
 * @version: v1.0
 */

@Slf4j

public class TreeDataUtils {

    /**
     * @Author qinyc
     * @Description
     * @Version: v1.0
     * @Date 11:32 2023/7/21
     * @Param :nodes 扁平化数据原型
     * @Return: java.util.List<T> 处理好的树形数据
     **/
    public static <T extends CategoryPageVO> List<T> convert(List<T> nodes) {

        //判断传进来的集合是否为空
        if (Collections.isEmpty(nodes)) {
            return Lists.newArrayList();
        }

        //创建List集合用于存放处理好的树状结构数据结果
        List<T> nodeTree = new ArrayList<>();
        //创建Map集合，存放已遍历节点和其父级子树，用于子级节点的合并
        Map<Integer, T> nodeMap = new HashMap<>(nodes.size());
        //存放节点类型，用于创建节点实例
        Class<T> clazz = (Class<T>) nodes.get(0).getClass();
        for (T t : nodes) {
            //此处只能获取到nodeMap中的子节点，因为它本身未加入，所以下一行代码不能更换顺序
            t.getChildren().addAll(nodeMap.containsKey(t.getId()) ? nodeMap.get(t.getId()).getChildren() : new ArrayList<>());
            //存放当前遍历节点
            nodeMap.put(t.getId(), t);
            //顶级节点直接添加，后续节点状态的变化通过修改堆中对象，从而栈中list引用堆对象也自然跟着变化
            if (Objects.isNull(t.getParentId())) {
                nodeTree.add(t);
            } else {
                //存放子级节点，不存在则通过节点类型先实例化后放入，而后将当前遍历对象直接添加至子级节点
                if (!nodeMap.containsKey(t.getParentId())) {  // (6)
                    T instance = null;
                    try {
                        instance = clazz.newInstance();
                    } catch (Exception e) {
                        log.error(e.getMessage(),e);
                    }
                    nodeMap.put(t.getParentId(), instance);
                }
                nodeMap.get(t.getParentId()).getChildren().add(t);
            }
        }
        return nodeTree;
    }
}
