package com.examweb.group.service;

import com.baomidou.mybatisplus.service.IService;
import com.examweb.group.entity.School;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: Jessiecaicai
 * @Description:
 * @Date:Created in 2018/7/3
 */
public interface SchoolService extends IService<School>{
    /**
     * @Description: 根据province取出学校list
     * @Json:
     * @Date: 2018/7/3
     * @Return:
     */
    @Select("select name from school where province=#{province}")
    List<String> getSchoolNameByProvince(@Param("province") String province);
}
