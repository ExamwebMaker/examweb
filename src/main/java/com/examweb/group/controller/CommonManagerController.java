package com.examweb.group.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Jessiecaicai
 * @Description:
 * @Date:Created in 2018/7/3
 */
@RestController
@RequestMapping("/commonManager")
public class CommonManagerController {
    ///**
    // * @Description: 普通管理员主页
    // * @Json:
    // * @Date: 2018/7/3
    // * @Return:
    // */
    //@RequestMapping(value = "/commonManagerAdmin", method = RequestMethod.GET)
    //public String commonManagerAdmin(){
    //    return "admin/adminlogin";
    //}

    /**
     * @Description: 普通管理员主页
     * @Json:
     * @Date: 2018/7/3
     * @Return:
     */
    @PostMapping("/adminlogin")
    public String commonUserAdmin(){
        return "admin/adminlogin";
    }

}
