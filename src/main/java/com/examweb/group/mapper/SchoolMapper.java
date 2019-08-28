package com.examweb.group.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.examweb.group.entity.School;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: Jessiecaicai
 * @Description:
 * @Date:Created in 2018/7/3
 */
@Component
public interface SchoolMapper extends BaseMapper<School> {

    /**
     * @Description: 根据province取出学校list
     * @Json:
     * @Date: 2018/7/3
     * @Return:
     */
    @Select("select name from school where province=#{province} and  is_delete=0")
    List<String> getSchoolByProvince(@Param("province") String province);

    /**
     * @Description: 根据province名字取出学校名字
     * @Json:
     * @Date: 2018/7/3
     * @Return:
     */
    @Select("select name from school where province=#{province} and is_delete=0")
    List<String> getSchoolNameByProvince(@Param("province") String province);

    /**
     * @Description: 取出所有学校的名字
     * @Json: 
     * @Date: 2018/7/5
     * @Return: 
     */
    @Select("select name from school where is_delete=0")
    List<String> getAllSchools();

    /**
     * @Description: 根据schoolname取出shool
     * @Json:
     * @Date: 2018/7/5
     * @Return:
     */
    @Select("select * from school where name=#{name} and is_delete=0")
    School getSchoolByName(@Param("name")String name);



}
