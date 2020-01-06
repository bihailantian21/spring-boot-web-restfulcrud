package com.zcr.exception;

public class UserNotExitException extends RuntimeException{
    //为了能够让它抛出去，让它继承运行时异常
    public UserNotExitException() {
        super("用户不存在");
    }

}
