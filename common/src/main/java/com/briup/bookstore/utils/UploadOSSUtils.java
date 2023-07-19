package com.briup.bookstore.utils;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * @className: UploadOSSUtils
 * @Description: 七牛云文件上传工具类
 * @author: qinyc
 * @date: 2023/7/18 22:01
 * @version: v1.0
 */

@Data
@Component
@ConfigurationProperties(prefix = "oss")
public class UploadOSSUtils {
    //AK
    private String accessKey;
    //SK
    private String secretKey;
    //桶
    private String bucket;
    //基础域名
    private String baseUrl;

    public String uploadOss(MultipartFile imgFile, String filePath){
        //构造一个带指定 Region 对象的配置类(根据七牛云服务器地区进行设置，这里autoRegion会自动匹配相应地区七牛云服务)
        Configuration configuration = new Configuration(Region.autoRegion());
        //将配置传入UploadManager
        UploadManager uploadManager = new UploadManager(configuration);
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = filePath;
        try {
            //选择文件路径进行上传（根据上传的文件转换成输入流）
            InputStream inputStream = imgFile.getInputStream();
            //验证AK与SK
            Auth auth = Auth.create(accessKey, secretKey);
            //指定桶
            String upToken = auth.uploadToken(bucket);
            try {
                Response response = uploadManager.put(inputStream,key,upToken,null, null);
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    ex2.printStackTrace();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return baseUrl+key;
    }
}
