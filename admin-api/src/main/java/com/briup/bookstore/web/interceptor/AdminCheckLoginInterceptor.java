package com.briup.bookstore.web.interceptor;

import com.briup.bookstore.exception.BookStoreException;
import com.briup.bookstore.utils.JsonWebTokenUtils;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.SystemException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @className: AdminCheckLoginInterceptor
 * @Description: 管理员登录校验拦截器
 * @author: qinyc
 * @date: 2023/7/18 20:56
 * @version: v1.0
 */
@Component
@Slf4j
public class AdminCheckLoginInterceptor implements HandlerInterceptor {
    /**
     * @Author qinyc
     * @Description  请求拦截
     * @version: v1.0
     * @Date 20:58 2023/7/18
     **/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        //输出拦截的请求
        log.info("后台管理系统登陆校验拦截器拦截到请求,请求路径为 : {}",request.getRequestURL());
        //判断是否是预请求
        if (request.getMethod().equals("OPTIONS")){
            return true;
        }
        //判断Token是否存在
        if (!StringUtils.hasText(request.getHeader("token"))){
            //没有Token
            throw new BookStoreException(BookStoreException.CodeMsgEnum.ADMIN_IS_NOT_LOGIN);
        }
        //token存在
        try {
            JsonWebTokenUtils.parseJWT(request.getHeader("token"));
        } catch (ExpiredJwtException e) {
            //管理员登录过期
            throw new BookStoreException(BookStoreException.CodeMsgEnum.ADMIN_LOGIN_TIMEOUT);
        }catch (MalformedJwtException e){
            //管理员令牌失效
            throw new BookStoreException(BookStoreException.CodeMsgEnum.ADMIN_TOKEN_IS_INVALID);
        }catch (Exception e){
            //服务器内部错误
            throw new BookStoreException(BookStoreException.CodeMsgEnum.ERROR);
        }
        //放行
        return true;
    }

    /**
     * @Author qinyc
     * @Description 响应拦截
     * @version: v1.0
     * @Date 20:58 2023/7/18
     **/
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }


    /**
     * @Author qinyc
     * @Description  渲染界面前执行
     * @version: v1.0
     * @Date 20:58 2023/7/18
     **/
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
