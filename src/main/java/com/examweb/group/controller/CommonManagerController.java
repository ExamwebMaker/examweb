package com.examweb.group.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @Author: Jessiecaicai
 * @Description:
 * @Date:Created in 2018/7/3
 */
@RestController
@RequestMapping("/commonManager")
public class CommonManagerController {

    /**
     * @Description: 普通管理员主页
     * @Json:
     * @Date: 2018/7/3
     * @Return:
     */
    @GetMapping("")
    public String commonUserAdmin(){
        return "admin/adminlogin";
    }

}
