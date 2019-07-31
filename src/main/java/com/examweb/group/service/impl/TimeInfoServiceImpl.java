package com.examweb.group.service.impl;

//import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.examweb.group.entity.TimeInfo;
import com.examweb.group.mapper.TimeInfoMapper;
import com.examweb.group.service.TimeInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;

/**
 * @Author: Jessiecaicai
 * @Description:
 * @Date:Created in 2018/7/6
 */
@Service
public class TimeInfoServiceImpl extends ServiceImpl<TimeInfoMapper,TimeInfo> implements TimeInfoService {

    @Resource TimeInfoMapper timeInfoMapper;

    @Override
    public String getContentById(String id){
        //Timestamp timestamp=timeInfoMapper.getDateTableContentById(id);
        //return timestamp;
        String string=timeInfoMapper.getDateTableContentById(id);
        return string;
    }
}
