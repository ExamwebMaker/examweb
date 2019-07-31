package com.examweb.group.service.impl;

//import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.examweb.group.entity.Examinee;
import com.examweb.group.mapper.ExamineeMapper;
import com.examweb.group.service.ExamineeService;
import com.examweb.group.utils.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Jessiecaicai
 * @Description:
 * @Date:Created in 2018/7/4
 */
@Service
public class ExamineeServiceImpl extends ServiceImpl<ExamineeMapper,Examinee> implements ExamineeService{

    @Resource
    private ExamineeMapper examineeMapper;

    @Override
    public List<Examinee> selectExamineeByZhaoshengUnit(String zhaoshengUnit) throws Exception{
        List<Examinee> examineeList=new ArrayList<>();
        examineeList=examineeMapper.selectExamineeByZhaoshengUnit(zhaoshengUnit);
        return examineeList;
    }

    @Override
    public PageInfo<Examinee> getSchoolExaminee(int pageNum, String zhaoshengUnit){
        PageHelper.startPage(pageNum,20);
        List<Examinee> examineeList=examineeMapper.selectExamineeByZhaoshengUnit(zhaoshengUnit);
        return new PageInfo<>(examineeList);

    }

    @Override
    public PageInfo<Examinee> getSchoolExamineeUnchecked(int pageNum,String zhaoshengUnit){
        PageHelper.startPage(pageNum,20);
        List<Examinee> examineeList=examineeMapper.selectExamineeByZhaoshengUnitUnchecked(zhaoshengUnit);
        return new PageInfo<>(examineeList);
    }

    @Override
    public PageInfo<Examinee> getSchoolExamineeChecked(int pageNum,String zhaoshengUnit){
        PageHelper.startPage(pageNum,20);
        List<Examinee> examineeList=examineeMapper.selectExamineeByZhaoshengUnitChecked(zhaoshengUnit);
        return new PageInfo<>(examineeList);
    }

    @Override
    public PageInfo<Examinee> getSchoolExamineeNoAgree(int pageNum,String zhaoshengUnit){
        PageHelper.startPage(pageNum,20);
        List<Examinee> examineeList=examineeMapper.selectExamineeByZhaoshengUnitNoAgree(zhaoshengUnit);
        return new PageInfo<>(examineeList);
    }
    @Override
    public Examinee getExamineeByAccountId(String id){
        Examinee examinee=examineeMapper.selectExamineeByAccountId(id);
        return examinee;
    }

}
