package com.briup.bookstore.exception;

public class BookStoreException extends  RuntimeException {
    /*
     * 状态码
     */
    private int code;

    /*
     * 提示信息
     */
    private String msg;

    /*
     * 获取状态码
     */
    public int getCode() {
        return code;
    }

    /*
     * 获取提示信息
     */
    public String getMsg() {
        return msg;
    }

    /*
     * 构造器，将枚举状态码和提示信息作为参数传入
     */
    public BookStoreException(CodeMsgEnum codeMsgEnum) {
        super(codeMsgEnum.getMsg());
        this.code = codeMsgEnum.getCode();
        this.msg = codeMsgEnum.getMsg();
    }

    /*
     * 构造器 ，将状态码和提示信息作为参数传入
     */
    public BookStoreException(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public enum CodeMsgEnum {
        //响应失败
        ERROR(500,"服务器内部错误"),

        //管理员用户名不能为空
        ADMIN_USERNAME_IS_NOT_NULL(501,"管理员用户名不能为空"),

        //管理员密码不能为空
        ADMIN_PASSWORD_IS_NOT_NULL(502,"管理员密码不能为空"),

        //管理员用户名或密码错误
        ADMIN_USERNAME_OR_PASSWORD_ERROR(503,"管理员用户名或密码错误"),

        //管理员未登录
        ADMIN_IS_NOT_LOGIN(504,"管理员未登录"),

        //管理员登录过期
        ADMIN_LOGIN_TIMEOUT(505,"管理员登录过期"),

        //管理员令牌失效
        ADMIN_TOKEN_IS_INVALID(506,"管理员令牌失效"),

        //管理员ID不能为空
        ADMIN_ID_IS_NOT_NULL(507,"管理员ID不能为空"),

        //管理员对象不存在
        ADMIN_IS_NOT_EXIST(508,"管理员对象不存在"),

        //管理员用户名已存在
        ADMIN_USERNAME_IS_EXIST(509,"管理员用户名已存在"),

        //待删除管理员ID集合不能为空
        TO_BE_DELETE_ADMIN_IDS_IS_NOT_NULL(510,"待删除管理员ID集合不能为空"),

        //文件格式错误
        FILE_TYPE_ERROR(511,"图片类型错误，只能是 .jpg 或 .png格式 "),

        //用户的用户名不能为空
        USER_USERNAME_IS_NOT_NULL(512,"用户的用户名不能为空"),

        //用户的密码不能为空
        USER_PASSWORD_IS_NOT_NULL(513,"用户的密码不能为空"),

        //用户的用户名已存在
        USER_USERNAME_IS_EXIST(514,"用户的用户名已存在"),

        //登录账号非管理员账号
        LOGIN_IS_NOT_ADMIN(515,"登录账号非管理员账号")
        ;


        //响应状态码
        int code;
        //响应信息
        String msg;

        //全参构造器
        CodeMsgEnum(int code, String errorMessage){
            this.code = code;
            this.msg = errorMessage;
        }

        //获取响应状态码
        public int getCode() {
            return code;
        }

        //获取响应信息
        public String getMsg() {
            return msg;
        }
    }

}