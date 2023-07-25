package com.briup.bookstore.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

/**
 * @className: JsonWebTokenUtils
 * @Description: JWT工具类
 * @author: qinyc
 * @date: 2023/7/18 21:04
 * @version: v1.0
 */

public class JsonWebTokenUtils {
    //有效期为
    public static final Long JWT_TTL = 24 * 60 * 60 * 1000L;// 60 * 60 *1000  一个小时
    //设置秘钥明文
    public static final String JWT_KEY = "estore";

    /**
     * @Author qinyc
     * @Description  获取UUID
     * @version: v1.0
     * @Date 21:05 2023/7/18
     **/
    public static String getUUID(){
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        return token;
    }

    /**
     * @Author qinyc
     * @Description  生成jtw   subject token中要存放的数据（json格式）
     * @version: v1.0
     * @Date 21:05 2023/7/18
     **/
    public static String createJWT(String subject) {
        JwtBuilder builder = getJwtBuilder(subject, null, getUUID());// 设置过期时间
        return builder.compact();
    }

    /**
     * @Author qinyc
     * @Description  生成jtw
     * @version: v1.0
     * @Date 21:05 2023/7/18
     **/
    public static String createJWT(String subject, Long ttlMillis) {
        // 设置过期时间
        JwtBuilder builder = getJwtBuilder(subject, ttlMillis, getUUID());
        return builder.compact();
    }

    /**
     * @Author qinyc
     * @Description  获取JwtBuilder对象
     * @version: v1.0
     * @Date 21:05 2023/7/18
     **/
    private static JwtBuilder getJwtBuilder(String subject, Long ttlMillis, String uuid) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        SecretKey secretKey = generalKey();
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        if(ttlMillis==null){
            ttlMillis=JsonWebTokenUtils.JWT_TTL;
        }
        long expMillis = nowMillis + ttlMillis;
        Date expDate = new Date(expMillis);
        return Jwts.builder()
                //唯一的ID
                .setId(uuid)
                // 主题  可以是JSON数据
                .setSubject(subject)
                // 签发者
                .setIssuer("qinyc")
                // 签发时间
                .setIssuedAt(now)
                //使用HS256对称加密算法签名, 第二个参数为秘钥
                .signWith(signatureAlgorithm, secretKey)
                .setExpiration(expDate);
    }

    /**
     * @Author qinyc
     * @Description  创建token
     * @version: v1.0
     * @Date 21:05 2023/7/18
     **/
    public static String createJWT(String id, String subject, Long ttlMillis) {
        // 设置过期时间
        JwtBuilder builder = getJwtBuilder(subject, ttlMillis, id);
        return builder.compact();
    }

    /**
     * @Author qinyc
     * @Description  生成加密后的秘钥 secretKey
     * @version: v1.0
     * @Date 21:05 2023/7/18
     **/
    public static SecretKey generalKey() {
        byte[] encodedKey = Base64.getDecoder().decode(JsonWebTokenUtils.JWT_KEY);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    /**
     * @Author qinyc
     * @Description  解析
     * @version: v1.0
     * @Date 21:06 2023/7/18
     **/
    public static Claims parseJWT(String jwt) throws Exception {
        SecretKey secretKey = generalKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody();
    }
}
