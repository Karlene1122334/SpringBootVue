package com.example.springbootandvue.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
public class FileUploadController {
    @PostMapping("/upload")
    public String up(String nickname, MultipartFile photo, HttpServletRequest request) throws IOException{
        System.out.println(nickname);

        System.out.println(photo.getOriginalFilename());

        System.out.println(photo.getContentType());

        //获取web服务器的运行目录，因为最终要把文件存储到这个服务器上 -> AKA 云端的linux系统
        //动态获取地址, HOW? -> HttpServletRequest
        /*HttpServletRequest
        request object -> get context of request from its instance method-> get web server index
        再拼接上自己写的这个upload path, which does not exist for now. But we can create it soon
        request.getServletContext().getRealPath will return a dynamic path where the server is running
        * */
        String path = request.getServletContext().getRealPath("/upload");
        System.out.println(path);
        saveFile(photo, path);

        return "Succeed.";
    }
    /*Postman mock
    * localhost:8080/upload
    * body - multipart/form-data
    * nickname text zhangsan
    * photo file (upload a pic)
    *
    * Cool thing: "the filed photo exceeds its maximum permitted size of xx bytes"
    *
    * Result of running:
    c:\users\liu\xxx\temp\tomcat-xxx.xxx\upload\
    * this is the dynamic path automatically located by idea
    *  */

    private void saveFile(MultipartFile photo, String path) throws IOException {
        File dir = new File(path);
        if(!dir.exists()){
            dir.mkdir();
        }

        //这个file就代表最终我要存储的那个文件, path + file name
        File file = new File(path+photo.getOriginalFilename());
        //write it into disk
        photo.transferTo(file);
        //what we have eventually - c:\users\xx\tomcat-xxx.xxx\upload\filename -> photo
    }


}
