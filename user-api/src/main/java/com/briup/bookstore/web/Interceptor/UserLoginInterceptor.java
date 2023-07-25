package com.briup.bookstore.web.Interceptor;

import com.briup.bookstore.exception.BookStoreException;
import com.briup.bookstore.utils.JsonWebTokenUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author briup-adam
 * @Date 2023/7/25 上午10:31
 * @Description
 **/
@Component
@Slf4j
public class UserLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //输出拦截的请求
        log.info("后台管理系统登陆校验拦截器拦截到请求,请求路径为 : {}",request.getRequestURL());
        //判断是否是预请求
        if (request.getMethod().equals("OPTIONS")){
            return true;
        }
        //判断Token是否存在
        if (!StringUtils.hasText(request.getHeader("token"))){
            //没有Token
            throw new BookStoreException(BookStoreException.CodeMsgEnum.USER_IS_NOT_LOGIN);
        }
        //token存在
        try {
            Claims jwt = JsonWebTokenUtils.parseJWT(request.getHeader("token"));
            String userId = jwt.getSubject();
            request.setAttribute("userId",userId);
        } catch (ExpiredJwtException e) {
            //管理员登录过期
            throw new BookStoreException(BookStoreException.CodeMsgEnum.USER_LOGIN_TIMEOUT);
        }catch (MalformedJwtException e){
            //管理员令牌失效
            throw new BookStoreException(BookStoreException.CodeMsgEnum.USER_TOKEN_IS_INVALID);
        }catch (Exception e){
            //服务器内部错误
            throw new BookStoreException(BookStoreException.CodeMsgEnum.ERROR);
        }
        //放行
        return true;
    }
}
