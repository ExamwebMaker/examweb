package com.examweb.group.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.examweb.group.entity.School;
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

    @Override
    public List<String> getSchoolNameByProvince(String province){
        List<String> listSchoolName=new ArrayList<>();
        listSchoolName=schoolMapper.getSchoolByProvince(province);
        return listSchoolName;
    }
}
