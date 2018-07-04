package com.examweb.group.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    //@GetMapping("/index")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "student/index";
    }

    /**
     * @Description: 普通管理员
     * @Json:
     * @Date: 2018/7/3
     * @Return:
     */
    @RequestMapping(value = "/commonUserAdmin", method = RequestMethod.GET)
    //@GetMapping("/login")
    public String commonUserAdmin() {
        return "admin/adminlogin";
    }

    /**
     * @Description: 超级管理员
     * @Json:
     * @Date: 2018/7/3
     * @Return:
     */
    @GetMapping("/superuserAdmin")
    public String superUserAdmin() {
        return "admin/adminlogin";
    }

    @GetMapping("/stdlogin")
    public String stdlogin() {
        return "student/login";
    }

    @GetMapping("/stdsignup")
    public String stdsigup() {
        return "student/signup";
    }

    @GetMapping("/stdcenter")
    public String stdcenter() {
        return "student/center";
    }

    @GetMapping("/stdmbaindex")
    public String stdmbaindx() {
        return "student/mbaindex";
    }

}
