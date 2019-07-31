package com.examweb.group.service;

//import com.baomidou.mybatisplus.service.IService;
import com.baomidou.mybatisplus.extension.service.IService;
import com.examweb.group.entity.School;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: Jessiecaicai
 * @Description:
 * @Date:Created in 2018/7/3
 */
public interface SchoolService extends IService<School> {

    /**
     * @Description: 根据province取出学校list
     * @Json:
     * @Date: 2018/7/3
     * @Return:
     */
    public List<String> getSchoolNameByProvince(String province);

    /**
     * @Description: 取出所有学校
     * @Json:
     * @Date: 2018/7/5
     * @Return:
     */
    public List<String> getAllSchools();

    /**
     * @Description: 根据学校的name取出学校
     * @Json:
     * @Date: 2018/7/5
     * @Return:
     */
    public School getSchoolByName(String name);

    /**
     * @Description: search
     * @Json:
     * @Date: 2018/7/6
     * @Return:
     */
    public List<String> search(String learnWay,String subjectId);
}
