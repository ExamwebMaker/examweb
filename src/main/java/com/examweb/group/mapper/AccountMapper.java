package com.examweb.group.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.examweb.group.entity.Account;
import com.examweb.group.entity.School;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: Jessiecaicai
 * @Description:
 * @Date:Created in 2018/7/2
 */
@Component
public interface AccountMapper extends BaseMapper<Account> {

    /**
     * @Description: 根据用户名和密码取出账号
     * @Json:
     * @Date: 2018/7/3
     * @Return:
     */
    @Select("select * from account where name=#{name} and password=#{password}")
    Account getAccountByNameAndPassword(@Param("name")String name,@Param("password")String password);

    /**
     * @Description: 根据用户名取出账号
     * @Json:
     * @Date: 2018/7/3
     * @Return:
     */
    @Select("select * from account where name=#{name}")
    Account getAccountByName(@Param("name")String name);

    ///**
    // * @Description: 根据
    // * @Json:
    // * @Date: 2018/7/4
    // * @Return:
    // */



}
