package com.zcr.controller;

import com.zcr.exception.UserNotExitException;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

    //浏览器和客户端返回的都是json
    /*@ResponseBody
    @ExceptionHandler(UserNotExitException.class)
    public Map<String,Object> handlerException(Exception e) {
        Map<String,Object> map=new HashMap<>();
        map.put("code","user.noteexist");
        map.put("message",e.getMessage());
        return map;
    }*/


    //浏览器是定制页面，客户端是json数据，但是json数据不是我们设置的错误消息
    @ExceptionHandler(UserNotExitException.class)
    public String handlerException(Exception e, HttpServletRequest request) {
        Map<String,Object> map=new HashMap<>();
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code","user.notexist");
        map.put("message","用户出错啦");

        request.setAttribute("ext",map);
        //转发到/error
        return "forward:/error";
    }


}
