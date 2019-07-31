package com.examweb.group.mapper;

//import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.examweb.group.entity.TimeInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * @Author: Jessiecaicai
 * @Description:
 * @Date:Created in 2018/7/6
 */
@Component
public interface TimeInfoMapper extends BaseMapper<TimeInfo> {

    @Select("select content from time_info where is_delete=0 and id=#{key}")
    String getDateTableContentById(@Param("key")String id);

}
