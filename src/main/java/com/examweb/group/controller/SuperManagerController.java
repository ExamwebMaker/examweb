package com.examweb.group.controller;

import com.examweb.group.dto.Result;
import com.examweb.group.entity.Account;
import com.examweb.group.service.AccountService;
import com.examweb.group.utils.ResultUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.util.UUID;

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
   @PostMapping("/designAccount")
   @CrossOrigin
    public Result designAccount(@RequestBody @Valid Account account, BindingResult bindingResult){
       if (bindingResult.hasErrors()){
           return ResultUtil.fail(bindingResult.getAllErrors().toString());
       }
       //判断用户名是否存在
       try {
           Account accountGet;
           accountGet=accountService.getAccountByName(account.getName());
           if (accountGet!=null){
               return ResultUtil.fail("账号名已经存在");
           }
       }catch (Exception e){
           e.printStackTrace();
       }
       System.out.println(account.toString());
       try {
           account.setId(UUID.randomUUID().toString().replaceAll("-",""));
           account.setPhone("管理员电话");
           account.setEmail("管理员邮件");
           account.setCertificateStyle("0");
           account.setCertificateNumber("管理员证件号码");
           account.setAccountStyle("1");
           account.setCreateTime(new Date(System.currentTimeMillis()));
           account.setUpdateTime(new Date(System.currentTimeMillis()));
           account.setIsDelete("0");
           System.out.println(account.toString());
           accountService.insert(account);
           return ResultUtil.OK();
       }catch (Exception e){
           e.printStackTrace();
       }
       return ResultUtil.fail("新增管理员失败");
   }

   /**
    * @Description: 超级管理员查看已分配的管理员
    * @Json:
    * @Date: 2018/7/4
    * @Return:
    */
   @PostMapping("/selectManager/{pageNum}")
   @CrossOrigin
    public Result selectManager(@PathVariable("pageNum") Integer pageNum){
       if (pageNum<=0){
           pageNum=1;
       }
       try {
           PageInfo<Account> accountPageInfo=accountService.selectAllManager(pageNum);
           return ResultUtil.OK(accountPageInfo);
       }catch (Exception e){
           e.printStackTrace();
       }
       return ResultUtil.selectError();
   }
}
