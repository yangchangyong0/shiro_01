package com.ycy.Exception;

/**
 *  系统自定义系统异常，实际开发时需要多个
 * Created by Administrator on 2015/10/10 0010.
 */
public class CustomException extends  Exception{
    //异常信息
    private  String  message;

    public CustomException(String message){
        super(message);
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
