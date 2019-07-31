package com.examweb.group.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
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
    @CrossOrigin
    public String index1() {
        return "student/index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @CrossOrigin
    public String index2() {
        return "student/index";
    }

    @RequestMapping(value = "/zhunkao", method = RequestMethod.GET)
    @CrossOrigin
    public String zhun() {
        return "student/zhunkaozheng";
    }


    @RequestMapping(value = "/adminlogin", method = RequestMethod.GET)
    @CrossOrigin
    //@GetMapping("/login")
    public String commonUserAdmin() {
        return "admin/adminlogin";
    }

    @RequestMapping(value = "/superindex", method = RequestMethod.GET)
    @CrossOrigin
    //@GetMapping("/login")
    public String superindex() {
        return "admin/superindex";
    }

    @RequestMapping(value = "/adminindex", method = RequestMethod.GET)
    @CrossOrigin
    //@GetMapping("/login")
    public String adminindex() {
        return "admin/adminindex";
    }


    @GetMapping("/stdlogin")
    @CrossOrigin
    public String stdlogin() {
        return "student/login";
    }

    @GetMapping("/stdsignup")
    @CrossOrigin
    public String stdsigup() {
        return "student/signup";
    }

    @GetMapping("/stdcenter")
    @CrossOrigin
    public String stdcenter() {
        return "student/center";
    }

    @GetMapping("/stdmbaindex")
    @CrossOrigin
    public String stdmbaindx() {
        return "student/mbaindex";
    }

    @GetMapping("/stdenroll")
    @CrossOrigin
    public String stdenroll() {
        return "student/enroll";
    }

    @GetMapping("/stdpay")
    @CrossOrigin
    public String stdpay() {
        return "student/pay";
    }

    @GetMapping("/stdaccountedit")
    @CrossOrigin
    public String stdaccountedit() {
        return "student/accountedit";
    }

}
