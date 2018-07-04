package com.examweb.group.controller;

import com.examweb.group.dto.Result;
import com.examweb.group.entity.Account;
import com.examweb.group.service.AccountService;
import com.examweb.group.service.SchoolService;
import com.examweb.group.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Jessiecaicai
 * @Description: 所有角色通用的接口集
 * @Date:Created in 2018/7/3
 */
@RestController
@RequestMapping(value = "/commonUser")
public class CommonActionController {

    private AccountService accountService;
    private SchoolService schoolService;

    @Autowired
    protected CommonActionController(AccountService accountService,SchoolService schoolService){
        this.accountService=accountService;
        this.schoolService=schoolService;
    }

    ///**
    // * @Description: 基本主页
    // * @Json:
    // * @Date: 2018/7/3
    // * @Return:
    // */
    //@GetMapping("/index")
    //public String index(){
    //    return "student/index";
    //}

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
    public Result login(@RequestBody Account account, HttpSession session) {
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
     * @Description: 根据province取出学校名字列表
     * @Json:
     * @Date: 2018/7/3
     * @Return:
     */
    @PostMapping("/getSchoolNameByProvince/{province}")
    public Result getSchoolNameByProvince(@PathVariable("province") String province){
        try {
            //String province=examWeb;
            if (province==null||province.trim().isEmpty()){
                return ResultUtil.fail("请求的省市不能为空");
            }
            List<String> listName=new ArrayList<>();
            listName=schoolService.getSchoolNameByProvince(province);
            return ResultUtil.OK(listName);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultUtil.selectError();
    }
}
