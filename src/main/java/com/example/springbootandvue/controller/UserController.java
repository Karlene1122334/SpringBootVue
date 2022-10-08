package com.example.springbootandvue.controller;

import com.example.springbootandvue.entity.User;
import com.example.springbootandvue.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/user")
    public List<User> query(){
//        List<User> users = userMapper.find(); @MyBatis
//        @Mybatisplus
        List<User> users = userMapper.selectList(null);
        return users;
    }

    @PostMapping("/user")
    public String save(User user){
        int i = userMapper.insert(user);
        if (i>0) {
            return "successfully insert";
        }else{
            return "failed";
        }
    }
}
