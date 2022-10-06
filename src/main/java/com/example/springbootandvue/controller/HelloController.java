package com.example.springbootandvue.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
//    @GetMapping("/hello")
    //request: localhost:8000/hello?nickname=zhangsan
    //multiple params: ?nickname=zhangsan&phonenumber=123123
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(String nickname){
        return "Hello " + nickname;
    }
}
