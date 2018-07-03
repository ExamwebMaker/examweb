package com.examweb.group.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: Jessiecaicai
 * @Description:
 * @Date:Created in 2018/7/3
 */
@Controller
public class PageController {
    /**
     * @Description: 普通用户
     * @Json:
     * @Date: 2018/7/3
     * @Return:
     */
    @GetMapping("/index")
    public String index(){
        return "student/index";
    }

    /**
     * @Description: 普通管理员
     * @Json:
     * @Date: 2018/7/3
     * @Return:
     */
    @GetMapping("/login")
    public String commonUserAdmin(){
        return "admin/adminlogin";
    }

    /**
     * @Description: 超级管理员
     * @Json:
     * @Date: 2018/7/3
     * @Return:
     */
    @GetMapping("/index")
    public String superUserAdmin(){
        return "admin/adminlogin";
    }
}
