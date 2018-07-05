package com.examweb.group.controller;

import com.examweb.group.dto.Result;
import com.examweb.group.entity.Account;
import com.examweb.group.entity.Examinee;
import com.examweb.group.service.AccountService;
import com.examweb.group.service.ExamineeService;
import com.examweb.group.utils.ResultUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @Author: Jessiecaicai
 * @Description:
 * @Date:Created in 2018/7/3
 */
@RestController
@RequestMapping("/commonManager")
public class CommonManagerController {

    private ExamineeService examineeService;
    private AccountService accountService;

    @Autowired
    protected CommonManagerController(ExamineeService examineeService,AccountService accountService){
        this.examineeService=examineeService;
        this.accountService=accountService;
    }

    /**
     * @Description: 普通管理员查看报考本校的考生信息
     * @Json:
     * @Date: 2018/7/4
     * @Return:
     */
    @GetMapping("/examinee/{zhaoshengUnit}/{pageNum}")
    @CrossOrigin
    public Result schoolExaminee(@PathVariable(value = "zhaoshengUnit")String zhaoshengUnit,@PathVariable(value = "pageNum")Integer pageNum){
        if (pageNum<=0){
            pageNum=1;
        }
        try {
            PageInfo<Examinee> examineePageInfo= examineeService.getSchoolExaminee(pageNum,zhaoshengUnit);
            return ResultUtil.OK(examineePageInfo);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultUtil.selectError();
    }

    /**
     * @Description: 用于普通用户登录的接口
     * @Json: {
    "name": "string",
    "password": "string"
    }
     * @Date: 2018/7/3
     * @Return:
     */
    @PostMapping("/managerLogin")
    @CrossOrigin
    public Result managerLogin(@RequestBody Account account, HttpSession session) {
        String name=account.getName();
        String password=account.getPassword();
        if (name==null||name.trim().isEmpty()){
            return ResultUtil.fail("输入用户名不能为空");
        }
        if (password==null||password.trim().isEmpty()){
            return ResultUtil.fail("输入密码不能为空");
        }
        try {
            if (accountService.checkManagerIsExist(name,password)==0){
                Account accountGet=accountService.getManagerByNameAndPassword(name,password);
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
     * @Description: 普通管理员对报考本校的考生信息进行更新操作
     * @Json:
     * @Date: 2018/7/4
     * @Return:
     */
    @PostMapping("/updateExaminee")
    @CrossOrigin
    public Result updateSchoolExaminee(@RequestBody @Valid Examinee examinee, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResultUtil.fail(bindingResult.getAllErrors().toString());
        }
        System.out.print(examinee.toString());
        if (examineeService.updateById(examinee)){
            try {
                return ResultUtil.OK();
            }catch (Exception e){
                e.printStackTrace();
            }

        }

        return ResultUtil.fail("修改考生信息失败");
    }

}
