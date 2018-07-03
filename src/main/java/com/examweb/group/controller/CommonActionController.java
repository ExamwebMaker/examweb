package com.examweb.group.controller;

import com.examweb.group.dto.Result;
import com.examweb.group.entity.Account;
import com.examweb.group.service.AccountService;
import com.examweb.group.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Jessiecaicai
 * @Description: 所有角色通用的接口集
 * @Date:Created in 2018/7/3
 */
@RestController
@RequestMapping(value = "/commonAction")
public class CommonActionController {

    private AccountService accountService;

    @Autowired
    protected CommonActionController(AccountService accountService){
        this.accountService=accountService;
    }

    /**
     * @Description:
     * @Json:
     * @Date: 2018/7/3
     * @Return:
     */
    @RequestMapping("/index")
    public void index(){

    }

    /**
     * @Description: 用于所有的用户登录的接口
     * @Json: {
    "name": "string",
    "password": "string"
    }
     * @Date: 2018/7/3
     * @Return:
     */
    @PostMapping("/login")
    public Result login(@RequestBody Account account) {
        String name=account.getName();
        String password=account.getPassword();
        if (name==null||name.trim().isEmpty()){
            return ResultUtil.fail("输入用户名不能为空");
        }
        if (password==null||password.trim().isEmpty()){
            return ResultUtil.fail("输入密码不能为空");
        }
        try {
            if (accountService.checkAccoutIsExist(name,password)==0){
                Account accountGet=accountService.getAccountByNameAndPassword(name,password);
                //System.out.print(accountGet.getAccountStyle());
                return ResultUtil.OK(accountGet.getAccountStyle());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultUtil.fail("登入失败");
    }
}
