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
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index1() {
        return "student/index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index2() {
        return "student/index";
    }


    @RequestMapping(value = "/adminlogin", method = RequestMethod.GET)
    //@GetMapping("/login")
    public String commonUserAdmin() {
        return "admin/adminlogin";
    }

    @RequestMapping(value = "/superindex", method = RequestMethod.GET)
    //@GetMapping("/login")
    public String superindex() {
        return "admin/superindex";
    }

    @RequestMapping(value = "/adminindex", method = RequestMethod.GET)
    //@GetMapping("/login")
    public String adminindex() {
        return "admin/adminindex";
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

    @GetMapping("/stdenroll")
    public String stdenroll() {
        return "student/enroll";
    }

    @GetMapping("/stdpay")
    public String stdpay() {
        return "student/pay";
    }

    @GetMapping("/stdaccountedit")
    public String stdaccountedit() {
        return "student/accountedit";
    }

}
