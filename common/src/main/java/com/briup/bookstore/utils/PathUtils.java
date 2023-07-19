package com.briup.bookstore.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @className: PathUtils
 * @Description:
 * @author: qinyc
 * @date: 2023/7/18 21:59
 * @version: v1.0
 */

public class PathUtils {
    
    /**
     * @Author qinyc
     * @Description  七牛云上传文件统一文件格式: yyyy/MM/dd/随机UUID.文件格式
     * @version: v1.0
     * @Date 22:00 2023/7/18
     **/
    public static String generateFilePath(String fileName){
        //根据日期生成路径   2022/1/15/
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");
        String datePath = sdf.format(new Date());
        //uuid作为文件名
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        //后缀和文件后缀一致
        int index = fileName.lastIndexOf(".");
        // test.png -> .png
        String fileType = fileName.substring(index);
        return new StringBuilder().append(datePath).append(uuid).append(fileType).toString();
    }
}
