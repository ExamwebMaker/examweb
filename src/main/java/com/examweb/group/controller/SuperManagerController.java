package com.examweb.group.controller;

import com.examweb.group.dto.Result;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Jessiecaicai
 * @Description:
 * @Date:Created in 2018/7/3
 */
@RequestMapping("/superManager")
@RestController
public class SuperManagerController {

    /**
     * @Description: 超级管理员主页
     * @Json:
     * @Date: 2018/7/3
     * @Return:
     */
    @GetMapping("")
    public String superUserAdmin(){
        return "admin/adminlogin";
    }

    /**
     * @Description: 超级管理员给普通管理员分配账号
     * @Json:
     * @Date: 2018/7/3
     * @Return:
     */
    //@PostMapping("/giveCommomManager")
    //public Result addCommonManager(@RequestBody)
}
