package com.zcr.controller;

import com.zcr.exception.UserNotExitException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "hello web!";
    }

    //查出一些数据，在页面显示
    @RequestMapping("/success")
    public String success(Map<String,Object> map) {
        map.put("hello","<h1>你好</h1>");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
        //classpath:/templates/success.html
        return "success";
    }

//    @RequestMapping({"/","/login.html"})
//    public String index() {
//        return "login";
//    }

    @ResponseBody
    @RequestMapping("/testerror")
    public String testerror(@RequestParam("user") String user) {
        if (user.equals("aaa")) {
            throw new UserNotExitException();
        }
        return "hello testerror!";
    }
}
