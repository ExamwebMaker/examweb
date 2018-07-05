package com.examweb.group.controller;

import com.examweb.group.dto.Result;
import com.examweb.group.entity.Account;
import com.examweb.group.service.AccountService;
import com.examweb.group.utils.ResultUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
     * @Description: 用于超级管理员登录的接口
     * @Json: {
    "name": "string",
    "password": "string"
    }
     * @Date: 2018/7/3
     * @Return:
     */
    @PostMapping("/superLogin")
    @CrossOrigin
    public Result superLogin(@RequestBody Account account, HttpSession session) {
        String name=account.getName();
        String password=account.getPassword();
        if (name==null||name.trim().isEmpty()){
            return ResultUtil.fail("输入用户名不能为空");
        }
        if (password==null||password.trim().isEmpty()){
            return ResultUtil.fail("输入密码不能为空");
        }
        try {
            if (accountService.checkSuperIsExist(name,password)==0){
                Account accountGet=accountService.getSuperByNameAndPassword(name,password);
                //System.out.print(accountGet.toString());
                session.setAttribute("account",accountGet);
                //session.setAttribute("accountId",accountGet.getId());
                //session.setAttribute("name",accountGet.getName());
                //session.setAttribute("certificateStyle",accountGet.getCertificateStyle());
                //session.setAttribute("crtificateNumber",accountGet.getCertificateNumber());
                //System.out.print(accountGet.getAccountStyle());
                return ResultUtil.OK(accountGet);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultUtil.fail("登入失败");
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
