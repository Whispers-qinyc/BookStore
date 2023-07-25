package com.briup.bookstore.service.impl;

import com.briup.bookstore.exception.BookStoreException;
import com.briup.bookstore.response.Result;
import com.briup.bookstore.service.UploadService;
import com.briup.bookstore.utils.PathUtils;
import com.briup.bookstore.utils.UploadOSSUtils;
import org.omg.CORBA.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @className: UploadServiceImpl
 * @Description: 文件上传模块service接口实现类
 * @author: qinyc
 * @date: 2023/7/18 22:07
 * @version: v1.0
 */
@Service
public class UploadServiceImpl implements UploadService {

    //注入UploadOSSUtils对象
    @Autowired
    private UploadOSSUtils uploadOSSUtils;

    /**
     * @Author qinyc
     * @Description  图片上传接口
     * @version: v1.0
     * @Date 22:09 2023/7/18
     **/
    @Override
    public String upload(MultipartFile img) {
        //判断文件类型
        //获取原始文件名
        String originalFilename = img.getOriginalFilename();
        //对原始文件名进行判断
        if((!originalFilename.endsWith(".png")) && (!originalFilename.endsWith(".jpg"))){
            //抛出文件上传格式错误提示
            throw new BookStoreException(BookStoreException.CodeMsgEnum.FILE_TYPE_ERROR);
        }
        //判断通过，将文件上传到七牛云服务器
        //生成上传后的文件路径
        String filePath = PathUtils.generateFilePath(originalFilename);
        //上传文件
        String url = uploadOSSUtils.uploadOss(img, filePath);
        //返回上传成功响应
        return url;
    }
}
