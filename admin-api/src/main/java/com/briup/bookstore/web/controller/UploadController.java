package com.briup.bookstore.web.controller;

import com.briup.bookstore.response.Result;
import com.briup.bookstore.service.UploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @className: UploadController
 * @Description: 上传模块Controller层
 * @author: qinyc
 * @date: 2023/7/18 22:03
 * @version: v1.0
 */
@Api(tags = "文件上传模块")
@RestController
@RequestMapping("/admin")
public class UploadController {
    //注入Service层对象
    @Autowired
    private UploadService uploadService;

    /**
     * @Author qinyc
     * @Description  图片上传接口
     * @version: v1.0
     * @Date 22:04 2023/7/18
     **/
    @ApiOperation("图片上传接口")
    @PostMapping("/upload")
    public Result upload(@RequestPart MultipartFile img){
        String url = uploadService.upload(img);
        return Result.success(url);
    }
}
