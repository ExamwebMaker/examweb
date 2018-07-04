package com.examweb.group.controller;

import com.examweb.group.dto.Result;
import com.examweb.group.entity.Account;
import com.examweb.group.entity.Examinee;
import com.examweb.group.service.AccountService;
import com.examweb.group.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.util.UUID;

/**
 * @Author: Jessiecaicai
 * @Description:
 * @Date:Created in 2018/7/2
 */
@RestController
@RequestMapping(value = "/commomuser")
public class CommonUserController {

    private AccountService accountService;

    @Autowired
    protected CommonUserController(AccountService accountService){
        this.accountService=accountService;
    }

    ///**
    // * @Description: 普通用户主页
    // * @Json:
    // * @Date: 2018/7/3
    // * @Return:
    // */
    //@GetMapping("/")
    //public String index(){
    //    return "/templates/student/index";
    //}

    /**
     * @Description: 普通用户注册
     * @Json: {
    "certificateNumber": "string",
    "certificateStyle": "0",
    "email": "string",
    "id": "string",
    "name": "string",
    "password": "string",
    "phone": "string"
    }
     * @Date: 2018/7/3
     * @Return:
     */
    @PostMapping("/rigesterCommomUser")
    public Result rigesterCommomUser(@RequestBody @Valid Account account, BindingResult bindingResult){
        //System.out.print(account.getCertificateNumber());
        if (bindingResult.hasErrors()){
            return ResultUtil.fail(bindingResult.getAllErrors().toString());
        }
        //判断用户名是否已存在
        try {
            Account accountGet;
            accountGet=accountService.getAccountByName(account.getName());
            if (accountGet!=null){
                return ResultUtil.fail("账号名已经存在");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        account.setId(UUID.randomUUID().toString().replaceAll("-",""));
        account.setAccountStyle("0");
        account.setUpdateTime(new Date(System.currentTimeMillis()));
        account.setCreateTime(new Date(System.currentTimeMillis()));
        account.setIsDelete("0");
        //System.out.print(account.toString());
        try {
            if (accountService.insert(account)){

                return ResultUtil.OK(account);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultUtil.insertError();
    }

   ///**
   // * @Description: 用户新增报名信息
   // * @Json:
   // * @Date: 2018/7/4
   // * @Return:
   // */
   //@PostMapping("/addExam")
   // public Result addExam(@ResponseBody @Valid Examinee examinee,BindingResult bindingResult){
   //    if (bindingResult.hasErrors()){
   //        return ResultUtil.fail(bindingResult.getAllErrors().toString());
   //    }
   //
   //}

}
