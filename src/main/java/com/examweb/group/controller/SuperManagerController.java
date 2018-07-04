package com.examweb.group.controller;

import com.examweb.group.dto.Result;
import com.examweb.group.entity.Account;
import com.examweb.group.service.AccountService;
import com.examweb.group.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Author: Jessiecaicai
 * @Description:
 * @Date:Created in 2018/7/3
 */
@RequestMapping("/superManager")
@RestController
public class SuperManagerController {

    private AccountService accountService;

    @Autowired
    protected SuperManagerController(AccountService accountService){
        this.accountService=accountService;
    }


    /**
     * @Description: 超级管理员给普通管理员分配账号
     * @Json:
     * @Date: 2018/7/3
     * @Return:
     */
//   @PostMapping("/designAccount")
//    public Result designAccount(@RequestBody @Valid Account account, BindingResult bindingResult){
//       if (bindingResult.hasErrors()){
//           return ResultUtil.fail(bindingResult.getAllErrors().toString());
//       }
//   }
}
