package com.briup.bookstore.utils;

import com.briup.bookstore.po.Ip;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;

/**
 * @className: IpUtils
 * @Description: ip工具类
 * @author: qinyc
 * @date: 2023/7/23 17:36
 * @version: v1.0
 */

public class IpUtils {
    /**
     * @Author qinyc
     * @Description 通过请求获取真实ip地址
     * @Version: v1.0
     * @Date 17:36 2023/7/23
     * @Param :request
     * @Return: java.lang.String
     **/
    public static String getIpAddr(HttpServletRequest request) {
        String ipAddress = null;
        try {
            //X-Forwarded-For：Squid 服务代理
            String ipAddresses = request.getHeader("X-Forwarded-For");

            if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
                //Proxy-Client-IP：apache 服务代理
                ipAddresses = request.getHeader("Proxy-Client-IP");
            }

            if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
                //WL-Proxy-Client-IP：weblogic 服务代理
                ipAddresses = request.getHeader("WL-Proxy-Client-IP");
            }

            if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
                //HTTP_CLIENT_IP：有些代理服务器
                ipAddresses = request.getHeader("HTTP_CLIENT_IP");
            }

            if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
                //X-Real-IP：nginx服务代理
                ipAddresses = request.getHeader("X-Real-IP");
            }

            //有些网络通过多层代理，那么获取到的ip就会有多个，一般都是通过逗号（,）分割开来，并且第一个ip为客户端的真实IP
            if (ipAddresses != null && ipAddresses.length() != 0) {
                ipAddress = ipAddresses.split(",")[0];
            }

            //还是不能获取到，最后再通过request.getRemoteAddr();获取
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
                ipAddress = request.getRemoteAddr();
            }
        } catch (Exception e) {
            ipAddress = "";
        }
        return ipAddress;
    }

    /**
     * @Author qinyc
     * @Description 调用太平洋网络IP地址查询Web接口（http://whois.pconline.com.cn/），返回ip、地理位置
     * @Version: v1.0
     * @Date 17:49 2023/7/23
     * @Param :ip
     * @Return: com.briup.bookstore.po.Ip
     **/
    public static Ip getIp(String ip){
        //查本机
        String url = "http://whois.pconline.com.cn/ipJson.jsp?json=true";

        //查指定ip
        if(StringUtils.hasText(ip)){
            url = "http://whois.pconline.com.cn/ipJson.jsp?json=true&ip=" + ip;
        }

        StringBuilder inputLine = new StringBuilder();
        String read;
        try {
            HttpURLConnection urlConnection = (HttpURLConnection) new URL(url).openConnection();
            urlConnection.setRequestProperty("Charset", "GBK");
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "GBK"));
            while ((read = in.readLine()) != null) {
                inputLine.append(read);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //返回格式
        /*
        {
            ip: "58.63.47.115",
            pro: "广东省",
            proCode: "440000",
            city: "广州市",
            cityCode: "440100",
            region: "天河区",
            regionCode: "440106",
            addr: "广东省广州市天河区 电信",
            regionNames: "",
            err: ""
        }
         */
        Ip ipPO = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            //当属性的值为空（null或者""）时，不进行序列化，可以减少数据传输
            mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
            //设置日期格式
            mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
            //转换成IpVo
            ipPO = mapper.readValue(new String(inputLine.toString().getBytes("GBK"), "GBK"), Ip.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ipPO;
    }

    /**
     * @Author qinyc
     * @Description 直接根据访问者的Request，返回ip、地理位置
     * @Version: v1.0
     * @Date 17:49 2023/7/23
     * @Param :request
     * @Return: com.briup.bookstore.po.Ip
     **/
    public static Ip getIpByRequest(HttpServletRequest request){
        return IpUtils.getIp(IpUtils.getIpAddr(request));
    }
    /*
        终极大法：java获取不了，就用js来获取
        <!-- js获取客户ip -->
        <script src="http://whois.pconline.com.cn/ipJson.jsp"></script>
     */
}
