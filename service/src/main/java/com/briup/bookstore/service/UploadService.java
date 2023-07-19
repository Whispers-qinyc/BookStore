package com.briup.bookstore.service;

import com.briup.bookstore.response.Result;
import org.springframework.web.multipart.MultipartFile;

/**
 * @className: UploadService
 * @Description: 文件上传模块service接口
 * @author: qinyc
 * @date: 2023/7/18 22:06
 * @version: v1.0
 */

public interface UploadService {

    /**
     * @Author qinyc
     * @Description  图片上传接口
     * @version: v1.0
     * @Date 22:09 2023/7/18
     **/
    Result upload(MultipartFile img);
}
