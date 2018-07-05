package com.examweb.group.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.examweb.group.entity.Examinee;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: Jessiecaicai
 * @Description:
 * @Date:Created in 2018/7/4
 */
@Component
public interface ExamineeMapper extends BaseMapper<Examinee> {
    /**
     * @Description: 根据学校名称（招生单位）获取考生信息，包括所有审核状态的，但是isDelete为0（表示存在）
     * @Json:
     * @Date: 2018/7/4
     * @Return:
     */
    @Select("select * from examinee where is_delete=0 and zhaosheng_unit=#{zhaosheng_unit}")
    List<Examinee> selectExamineeByZhaoshengUnit(@Param("zhaosheng_unit")String zhaosheng_unit);

    /**
     * @Description: 根据学校名称（招生单位）获取考生信息，待审核，但是isDelete为0（表示存在）
     * @Json:
     * @Date: 2018/7/4
     * @Return:
     */
    @Select("select * from examinee where is_delete=0 and zhaosheng_unit=#{zhaosheng_unit} and is_check=1")
    List<Examinee> selectExamineeByZhaoshengUnitUnchecked(@Param("zhaosheng_unit")String zhaosheng_unit);

    /**
     * @Description: 根据学校名称获取考生信息，已审核
     * @Json:
     * @Date: 2018/7/5
     * @Return:
     */
    @Select("select * from examinee where is_delete=0 and zhaosheng_unit=#{zhaosheng_unit} and is_check=0")
    List<Examinee> selectExamineeByZhaoshengUnitChecked(@Param("zhaosheng_unit")String zhaosheng_unit);

    /**
     * @Description: 根据学校名称获取考生信息，审核不通过
     * @Json:
     * @Date: 2018/7/5
     * @Return:
     */
    @Select("select * from examinee where is_delete=0 and zhaosheng_unit=#{zhaosheng_unit} and is_check=2")
    List<Examinee> selectExamineeByZhaoshengUnitNoAgree(@Param("zhaosheng_unit")String zhaosheng_unit);





}
