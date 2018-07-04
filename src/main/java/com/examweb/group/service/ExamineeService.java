package com.examweb.group.service;

import com.baomidou.mybatisplus.service.IService;
import com.examweb.group.entity.Examinee;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author: Jessiecaicai
 * @Description:
 * @Date:Created in 2018/7/4
 */
public interface ExamineeService extends IService<Examinee>{
    /**
     * @Description: 根据招生单位返回报考信息（含全部审核状态），isDelete为0
     * @Json:
     * @Date: 2018/7/4
     * @Return:
     */
    public List<Examinee> selectExamineeByZhaoshengUnit(String zhaoshengUnit) throws Exception;

    /**
     * @Description: 获取学校的报考信息,（含全部审核状态），isDelete为0
     * 分页，并且给前端返回的字段有id，name，sex，wantMajorName；
     * @Json:
     * @Date: 2018/7/4
     * @Return:
     */
    public PageInfo<Examinee> getSchoolExaminee(int pageNum,String zhaoshengUnit);

}
