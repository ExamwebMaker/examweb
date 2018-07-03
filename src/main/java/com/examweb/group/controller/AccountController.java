package com.examweb.group.controller;

import com.examweb.group.dto.Result;
import com.examweb.group.entity.Account;
import com.examweb.group.service.AccountService;
import com.examweb.group.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.sql.Date;

/**
 * @Author: Jessiecaicai
 * @Description:
 * @Date:Created in 2018/7/2
 */
@RestController
@RequestMapping(value = "/account")
public class AccountController {

    private AccountService accountService;

    @Autowired
    protected AccountController(AccountService accountService){
        this.accountService=accountService;
    }

    /**
     * @Description: 普通用户注册
     * @Json:
     * @Date: 2018/7/3
     * @Return:
     */
    @PostMapping("/commomUser")
    public Result addCommomUser(@RequestBody @Valid Account account, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultUtil.fail(bindingResult.getAllErrors().toString());
        }
        account.setAccountStyle("0");
        account.setUpdateTime(new Date(System.currentTimeMillis()));
        account.setCreateTime(new Date(System.currentTimeMillis()));

        System.out.print(account.toString());




        return ResultUtil.OK();
    }
}
