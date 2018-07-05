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
    @PostMapping("/examinee/{zhaoshengUnit}/{pageNum}")
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
     * @Description: 普通管理员对成功报考本校的考生信息进行更新操作
     * @Json: {
    "account_id": "st",
    "birthPlace": "string",
    "certificateNumber": "string",
    "certificateStyle": "0",
    "connectAddress": "string",
    "connectPostalcode": "string",
    "examPointAddress": "string",
    "examPointName": "string",
    "examSubject": "string",
    "examWay": "string",
    "filePlace": "string",
    "fileUnitAddress": "string",
    "fileUnitName": "string",
    "fileUnitPostalcode": "string",
    "hukouDetail": "string",
    "hukouPlace": "string",
    "id": "0bf5c44498da43a6b0d15c5402bd6ce8",
    "learnWay": "string",
    "marriage": "0",
    "name": "王伟伟",
    "nameSpell": "string",
    "nation": "string",
    "nativePlace": "string",
    "nowSolier": "0",
    "nowStudyOrWorkUnit": "string",
    "policy": "string",
    "researchWay": "string",
    "rewardAndPunishment": "string",
    "sex": "0",
    "specialPlan": "string",
    "wantDepartmentName": "string",
    "wantMajorName": "string",
    "zhaoshengUnit": "string"
    }
     * @Date: 2018/7/4
     * @Return:
     */
    @PostMapping("/updateExaminee")
    @CrossOrigin
    public Result updateSchoolExaminee(@RequestBody @Valid Examinee examinee, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResultUtil.fail(bindingResult.getAllErrors().toString());
        }
        String id=examinee.getId();
        Examinee examineeGet=examineeService.selectById(id);
        System.out.print(examineeGet.toString());
        examinee.setCreateTime(examineeGet.getCreateTime());
        examinee.setUpdateTime(examineeGet.getUpdateTime());
        examinee.setIsCheck(examineeGet.getIsCheck());
        examinee.setIsDelete(examineeGet.getIsDelete());
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

    /**
     * @Description: 查看待审核的报考该校的考生信息
     * @Json:
     * @Date: 2018/7/5
     * @Return:
     */
    @PostMapping("/getUncheckedSchoolExaminee/{zhaoshengUnit}/{pageNum}")
    @CrossOrigin
    public Result getUncheckedSchoolExaminee(@PathVariable(value = "zhaoshengUnit")String zhaoshengUnit,@PathVariable("pageNum")Integer pageNum){
        if (pageNum<=0){
            pageNum=1;
        }
        try {
            PageInfo<Examinee> examineePageInfo=examineeService.getSchoolExamineeUnchecked(pageNum,zhaoshengUnit);
            return ResultUtil.OK(examineePageInfo);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultUtil.selectError();
    }

    /**
     * @Description: 查看审核不通过的考生信息
     * @Json:
     * @Date: 2018/7/5
     * @Return:
     */
    @PostMapping("/getNoAgreeSchoolExaminee/{zhaoshengUnit}/{pageNum}")
    @CrossOrigin
    public Result getSchoolExamineeNoAgree(@PathVariable(value = "zhaoshengUnit")String zhaoshengUnit,@PathVariable("pageNum")Integer pageNum){
        if (pageNum<=0){
            pageNum=1;
        }
        try {
            PageInfo<Examinee> examineePageInfo=examineeService.getSchoolExamineeNoAgree(pageNum,zhaoshengUnit);
            return ResultUtil.OK(examineePageInfo);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultUtil.selectError();
    }

    /**
     * @Description: 查看已审核的报考该校的考生信息
     * @Json:
     * @Date: 2018/7/5
     * @Return:
     */
    @PostMapping("/getCheckedSchoolExaminee/{zhaoshengUnit}/{pageNum}")
    @CrossOrigin
    public Result getCheckedSchoolExaminee(@PathVariable("zhaoshengUnit")String zhaoshengUnit,@PathVariable("pageNum")Integer pageNum){
        if (pageNum<=0){
            pageNum=1;
        }
        try {
            PageInfo<Examinee> examineePageInfo=examineeService.getSchoolExamineeChecked(pageNum,zhaoshengUnit);
            return ResultUtil.OK(examineePageInfo);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultUtil.selectError();
    }

    /**
     * @Description: 进行审核操作
     * @Json:
     * @Date: 2018/7/5
     * @Return:
     */
    @PostMapping("/check")
    @CrossOrigin
    public Result checkOperation(@PathVariable("id")String id){
        try {
            Examinee examinee;
            examinee=examineeService.selectById(id);
            examinee.setIsCheck("0");
            examineeService.updateById(examinee);
            return ResultUtil.OK();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultUtil.deleteError();
    }


    /**
     * @Description: 进行审核不通过操作
     * @Json:
     * @Date: 2018/7/5
     * @Return:
     */
    @PostMapping("/uncheck")
    @CrossOrigin
    public Result unCheckOperation(@PathVariable("id")String id){
        try {
            Examinee examinee;
            examinee=examineeService.selectById(id);
            examinee.setIsCheck("2");
            examineeService.updateById(examinee);
            return ResultUtil.OK();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultUtil.deleteError();
    }

}
