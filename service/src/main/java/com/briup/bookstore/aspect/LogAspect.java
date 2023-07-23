package com.briup.bookstore.aspect;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.briup.bookstore.annotation.SystemLog;
import com.briup.bookstore.exception.BookStoreException;
import com.briup.bookstore.mapper.LogMapper;
import com.briup.bookstore.mapper.UserMapper;
import com.briup.bookstore.po.Ip;
import com.briup.bookstore.po.Log;
import com.briup.bookstore.po.User;
import com.briup.bookstore.utils.IpUtils;
import com.briup.bookstore.utils.JsonWebTokenUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.bitwalker.useragentutils.Browser;
import nl.bitwalker.useragentutils.OperatingSystem;
import nl.bitwalker.useragentutils.UserAgent;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @className: LogAspect
 * @Description: AOP实现日志功能
 * @author: qinyc
 * @date: 2023/7/23 12:36
 * @version: v1.0
 */

@Component
@Aspect
@Slf4j
@RequiredArgsConstructor
public class LogAspect {

    //开始时间
    public long startTime;

    //结束时间
    public long endTime;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private LogMapper logMapper;

    /**
     * @Author qinyc
     * @Description 配置切入点
     * @Version: v1.0
     * @Date 14:03 2023/7/23
     * @Param :
     * @Return: void
     **/
    @Pointcut("@annotation(com.briup.bookstore.annotation.SystemLog)")
    public void pt(){

    }

    /**
     * @Author qinyc
     * @Description 增强处理
     * @Version: v1.0
     * @Date 14:03 2023/7/23
     * @Param :joinPoint
     * @Return: java.lang.Object
     **/
    @Around("pt()")
    public Object printLog(ProceedingJoinPoint joinPoint) throws Throwable {

        Object ret;
        try {
            //核心方法执行之前执行的代码
            Log logPO = handleBefore(joinPoint);
            //连接点执行核心方法
            ret = joinPoint.proceed();
            //核心方法执行完执行的代码
            handleAfter(ret,logPO);
        } finally {
            // 结束后换行（根据不同系统匹配不同的换行符）
            log.info("=======End=======" + System.lineSeparator());
        }
        //正常返回结果
        return ret;
    }

    /**
     * @Author qinyc
     * @Description 执行核心方法之前执行的方法
     * @Version: v1.0
     * @Date 14:03 2023/7/23
     * @Param :joinPoint
     * @Return: void
     **/
    private Log handleBefore(ProceedingJoinPoint joinPoint) {
        //为开始时间赋值
        startTime = System.currentTimeMillis();
        //从容器中获取请求相关属性
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //获取到当前请求（HttpServletRequest）
        HttpServletRequest request = requestAttributes.getRequest();
        //创建日志实体对象
        Log logPO = new Log();
        //判断Token是否存在
        if (!StringUtils.hasText(request.getHeader("token"))){
            //没有Token
            throw new BookStoreException(BookStoreException.CodeMsgEnum.USER_IS_NOT_LOGIN);
        }
        //token存在
        try {
            //解析token
            Claims token = JsonWebTokenUtils.parseJWT(request.getHeader("token"));
            //获取token中的用户ID
            Integer id = Integer.parseInt((String) token.get("sub"));
            //根据id查询用户信息
            User user = userMapper.getUserById(id);
            //将用户名存入log实体对象中
            logPO.setUsername(user.getUsername());
        } catch (ExpiredJwtException e) {
            //登录过期
            throw new BookStoreException(BookStoreException.CodeMsgEnum.USER_LOGIN_TIMEOUT);
        }catch (MalformedJwtException e){
            //令牌失效
            throw new BookStoreException(BookStoreException.CodeMsgEnum.USER_TOKEN_IS_INVALID);
        }catch (Exception e){
            //服务器内部错误
            throw new BookStoreException(BookStoreException.CodeMsgEnum.ERROR);
        }
        //获取核心方法方法上的注解对象
        SystemLog systemLog = getSystemLog(joinPoint);
        log.info("=======Start=======");
        // 打印请求 URL
        log.info("URL            : {}",request.getRequestURL());
        logPO.setRequestUrl(request.getRequestURL().toString());

        // 打印请求方式
        log.info("RequestMethod            : {}",request.getMethod());
        logPO.setRequestMethod(request.getMethod());

        //获取浏览器信息
        String ieDetail = request.getHeader("User-Agent");
        //将获取到的浏览器信息转换成UserAgent对象
        UserAgent userAgent = UserAgent.parseUserAgentString(ieDetail);
        //获取系统信息
        OperatingSystem operatingSystem = userAgent.getOperatingSystem();
        //打印系统名称
        log.info("OperationName            : {}",operatingSystem.getName());
        logPO.setOperationName(operatingSystem.getName());

        //获取浏览器信息
        Browser browser = userAgent.getBrowser();
        //打印浏览器名称
        log.info("BrowserName            : {}",browser.getName());
        logPO.setBrowserName(browser.getName());

        //获取发送请求主机的真实IP
        String ipAddress = IpUtils.getIpAddr(request);
        //获取Ip相关信息，将解析结果存储在IP实体对象中
        Ip ip = IpUtils.getIp(ipAddress);
        //打印发送请求主机的真实IP
        log.info("IP            : {}",ip.getIp());
        logPO.setIp(ip.getIp());

        //打印Ip来源（地址+运营商）
        log.info("SOURCE            : {}",ip.getAddr());
        logPO.setSource(ip.getAddr());

        // 打印请求入参
//        log.info("Request Args   : {}", JSON.toJSONString(joinPoint.getArgs()) );
        log.info("Request Args   : {}", JSONUtil.toJsonStr(joinPoint.getArgs()));
        logPO.setParamsJson(JSONUtil.toJsonStr(joinPoint.getArgs()));

        // 打印描述信息
        log.info("BusinessName   : {}",systemLog.businessName());
        logPO.setBusinessName(systemLog.businessName());

        // 打印调用 controller 的全路径以及执行方法
        log.info("Class Method   : {}.{}",joinPoint.getSignature().getDeclaringTypeName(),((MethodSignature) joinPoint.getSignature()).getName());
        logPO.setClassPath(joinPoint.getSignature().getDeclaringTypeName());
        logPO.setMethodName(((MethodSignature) joinPoint.getSignature()).getName());

        return logPO;
    }

    /**
     * @Author qinyc
     * @Description 执行核心方法之后执行的代码
     * @Version: v1.0
     * @Date 14:04 2023/7/23
     * @Param :ret
     * @Return: void
     **/
    private void handleAfter(Object ret,Log logPO) {
        // 打印出参
        log.info("Response       : {}", JSON.toJSONString(ret));
        logPO.setResultJson(JSON.toJSONString(ret));

        //为结束时间赋值
        endTime = System.currentTimeMillis();
        //为请求接口耗时赋值
        logPO.setSpendTime(endTime-startTime);

        //插入日志
        logMapper.insertLog(logPO);
    }
    /**
     * @Author qinyc
     * @Description 获取核心方法方法上的注解对象
     * @Version: v1.0
     * @Date 14:04 2023/7/23
     * @Param :joinPoint
     * @Return: com.briup.bookstore.annotation.SystemLog
     **/
    private SystemLog getSystemLog(ProceedingJoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        SystemLog systemLog = methodSignature.getMethod().getAnnotation(SystemLog.class);
        return systemLog;
    }
}