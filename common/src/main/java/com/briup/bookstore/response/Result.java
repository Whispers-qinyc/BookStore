package com.briup.bookstore.response;

import com.briup.bookstore.exception.BookStoreException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("统一响应数据格式")
public class Result <T>{


    @ApiModelProperty("响应状态码")
    private Integer code;

    @ApiModelProperty("响应标识")
    private String message;

    @ApiModelProperty("响应数据")
    private T data;

    //把构造方法私有
    private Result() {
    }

    //成功静态方法
    public static Result success() {
        Result r = new Result();
        r.setCode(20000);
        r.setMessage("ok");
        return r;
    }

    //成功静态方法
    public static <T> Result success(T data) {
        Result r = new Result();
        r.setCode(200);
        r.setMessage("ok");
        r.setData(data);
        return r;
    }

    //失败静态方法
    public static Result error(int code, String msg) {
        Result r = new Result();
        r.setCode(code);
        r.setMessage(msg);
        return r;
    }
    //失败静态方法
    public static Result error(BookStoreException.CodeMsgEnum codeMsgEnum) {
        Result r = new Result();
        r.setCode(codeMsgEnum.getCode());
        r.setMessage(codeMsgEnum.getMsg());
        return r;
    }



}
