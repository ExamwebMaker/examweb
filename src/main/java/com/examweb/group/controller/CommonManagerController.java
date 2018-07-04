package com.examweb.group.controller;

import com.examweb.group.dto.Result;
import com.examweb.group.entity.Examinee;
import com.examweb.group.service.ExamineeService;
import com.examweb.group.utils.ResultUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Jessiecaicai
 * @Description:
 * @Date:Created in 2018/7/3
 */
@RestController
@RequestMapping("/commonManager")
public class CommonManagerController {

    private ExamineeService examineeService;

    @Autowired
    protected CommonManagerController(ExamineeService examineeService){
        this.examineeService=examineeService;
    }

    /**
     * @Description: 普通管理员查看报考本校的考生信息
     * @Json:
     * @Date: 2018/7/4
     * @Return:
     */
    @GetMapping("/examinee/{zhaoshengUnit}/{pageNum}")
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

}
