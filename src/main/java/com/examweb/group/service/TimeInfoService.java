package com.examweb.group.service;

//import com.baomidou.mybatisplus.service.IService;
import com.baomidou.mybatisplus.extension.service.IService;
import com.examweb.group.entity.TimeInfo;

import java.sql.Timestamp;

/**
 * @Author: Jessiecaicai
 * @Description:
 * @Date:Created in 2018/7/6
 */
public interface TimeInfoService extends IService<TimeInfo> {

    /**
     * @Description: 根据id获取content
     * @Json:
     * @Date: 2018/7/6
     * @Return:
     */
    public String getContentById(String id);
}
