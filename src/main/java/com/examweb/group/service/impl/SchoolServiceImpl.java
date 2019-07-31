package com.examweb.group.service.impl;

//import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.examweb.group.entity.School;
import com.examweb.group.mapper.CommonMapper;
import com.examweb.group.mapper.SchoolMapper;
import com.examweb.group.service.SchoolService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Jessiecaicai
 * @Description:
 * @Date:Created in 2018/7/3
 */
@Service
public class SchoolServiceImpl extends ServiceImpl<SchoolMapper,School> implements SchoolService{

    @Resource
    private SchoolMapper schoolMapper;
    @Resource
    private CommonMapper commonMapper;

    @Override
    public List<String> getSchoolNameByProvince(String province){
        List<String> listSchoolName=new ArrayList<>();
        listSchoolName=schoolMapper.getSchoolByProvince(province);
        return listSchoolName;
    }

    @Override
    public List<String> getAllSchools(){
        List<String> stringList=new ArrayList<>();
        stringList=schoolMapper.getAllSchools();
        return stringList;
    }

    @Override
    public School getSchoolByName(String name){
        School school=schoolMapper.getSchoolByName(name);
        System.out.print(school.getAccountId());
        return school;
    }
    @Override
    public List<String> search(String learnWay,String subjectId){
        List<String> stringList=commonMapper.search(learnWay,subjectId);
        return stringList;
    }
}
