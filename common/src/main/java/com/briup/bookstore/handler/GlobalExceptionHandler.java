package com.briup.bookstore.handler;

import com.briup.bookstore.exception.BookStoreException;
import com.briup.bookstore.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler
    public Result exceptionHandler(Exception e){
        if (e instanceof BookStoreException){
            BookStoreException bse= (BookStoreException) e;
            log.error("出现了异常！！！",e);
            return Result.error(bse.getCode(),bse.getMsg());
        }else {
            log.error("出现了异常！！！",e);
            return Result.error(BookStoreException.CodeMsgEnum.ERROR);
        }

    }
}
