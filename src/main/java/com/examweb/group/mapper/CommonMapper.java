package com.examweb.group.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: Jessiecaicai
 * @Description:
 * @Date:Created in 2018/7/6
 */
@Component
public interface CommonMapper {

    @Select("select school_name from subject_school where learn_way=#{learnWay} and subject_id=#{subjectId}")
    List<String> search(@Param("learnWay")String learnWay,@Param("subjectId")String subjectId);
}
