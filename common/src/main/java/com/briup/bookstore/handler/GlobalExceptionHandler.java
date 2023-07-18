package com.briup.bookstore.handler;

import com.briup.bookstore.exception.BookStoreException;
import com.briup.bookstore.response.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public Result exceptionHandler(Exception e){
        if (e instanceof BookStoreException){
            BookStoreException bse= (BookStoreException) e;
          return   Result.error(bse.getCode(),bse.getMsg());
        }else {
            return  Result.error(BookStoreException.CodeMsgEnum.ERROR);
        }

    }
}
