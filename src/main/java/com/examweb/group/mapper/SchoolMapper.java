package com.examweb.group.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
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
public interface SchoolMapper extends BaseMapper<School>{

    /**
     * @Description: 根据province取出学校list
     * @Json:
     * @Date: 2018/7/3
     * @Return:
     */
    @Select("select name from school where province=#{province} where is_delete=0")
    List<String> getSchoolByProvince(@Param("province") String province);

    /**
     * @Description: 根据province取出学校list
     * @Json:
     * @Date: 2018/7/3
     * @Return:
     */
    @Select("select name from school where province=#{province} where is_delete=0")
    List<String> getSchoolNameByProvince(@Param("province") String province);
}
