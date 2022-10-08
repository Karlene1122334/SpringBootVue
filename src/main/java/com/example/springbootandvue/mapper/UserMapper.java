package com.example.springbootandvue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootandvue.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    //tiny trap: camelcase field @ entity -> field_Name @ database
    //只写上方法declr,用注解实现 => mybatisplus: 连sql都不用写了
    //this annotation will go to .properties -> find out "mydb" -> execute selecting
    @Select("select * from user")
    public List<User> find();
    //Springboot 通过动态代理的方式生成一个实现类来implm这个intf

    @Insert("insert into user values(#{username),#{password},#{birthday}")
    //#{field} -> pass parameter field into query, so that user.username etc can be grabbed by query
    public int insert(User user);
    }

