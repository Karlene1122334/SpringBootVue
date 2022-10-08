package com.example.springbootandvue.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Timestamp;
@Data
public class User {
    /* @TableId(type = IdType.AUTO)
     private int id;*/
    private String username;
//MyBP default: field name = column name. If not => @TableFiled
    /* @TableField("name")
     private String username;*/

    private String password;
    private Timestamp birthday;

}
