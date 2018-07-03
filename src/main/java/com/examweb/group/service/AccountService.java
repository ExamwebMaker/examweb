package com.examweb.group.service;

import com.baomidou.mybatisplus.service.IService;
import com.examweb.group.entity.Account;

/**
 * @Author: Jessiecaicai
 * @Description:
 * @Date:Created in 2018/7/2
 */
public interface AccountService extends IService<Account> {

    /**
     * @Description: 根据账号和密码判断用户是否存在
     * @Json: 
     * @Date: 2018/7/3
     * @Return: 
     */
    public Integer checkAccoutIsExist(String name,String password)throws Exception;

    /**
     * @Description: 根据账号和密码取出用户
     * @Json:
     * @Date: 2018/7/3
     * @Return:
     */
    public Account getAccountByNameAndPassword(String name,String psssword) throws Exception;
    
    /**
     * @Description: 根据账号名取出账号
     * @Json: 
     * @Date: 2018/7/3
     * @Return: 
     */
    public Account getAccountByName(String name) throws Exception;

    /**
     * @Description:
     * @Json:
     * @Date: 2018/7/3
     * @Return:
     */
}
