package com.examweb.group.service;

//import com.baomidou.mybatisplus.service.IService;
import com.baomidou.mybatisplus.extension.service.IService;
import com.examweb.group.entity.Account;
import com.github.pagehelper.PageInfo;

/**
 * @Author: Jessiecaicai
 * @Description:
 * @Date:Created in 2018/7/2
 */
public interface AccountService extends IService<Account> {

    /**
     * @Description: 普通用户根据账号和密码判断用户是否存在
     * @Json: 
     * @Date: 2018/7/3
     * @Return: 
     */
    public Integer checkAccoutIsExist(String name,String password)throws Exception;

    /**
     * @Description: 普通管理员根据账号和密码判断用户是否存在
     * @Json:
     * @Date: 2018/7/3
     * @Return:
     */
    public Integer checkManagerIsExist(String name,String password)throws Exception;

    /**
     * @Description: 超级管理员根据账号和密码判断用户是否存在
     * @Json:
     * @Date: 2018/7/3
     * @Return:
     */
    public Integer checkSuperIsExist(String name,String password)throws Exception;

    /**
     * @Description: 根据账号和密码取出普通用户
     * @Json:
     * @Date: 2018/7/3
     * @Return:
     */
    public Account getAccountByNameAndPassword(String name,String psssword) throws Exception;

    /**
     * @Description: 根据账号和密码取出普通管理员
     * @Json:
     * @Date: 2018/7/3
     * @Return:
     */
    public Account getManagerByNameAndPassword(String name,String psssword) throws Exception;

    /**
     * @Description: 根据账号和密码取出超级管理员
     * @Json:
     * @Date: 2018/7/3
     * @Return:
     */
    public Account getSuperByNameAndPassword(String name,String psssword) throws Exception;
    
    /**
     * @Description: 根据账号名取出账号
     * @Json: 
     * @Date: 2018/7/3
     * @Return: 
     */
    public Account getAccountByName(String name) throws Exception;

    /**
     * @Description: 展示所有的普通管理员
     * @Json:
     * @Date: 2018/7/4
     * @Return:
     */
    public PageInfo<Account> selectAllManager(int PageNum) throws Exception;

    /**
     * @Description: 展示所有的已注册账户
     * @Json:
     * @Date: 2018/7/5
     * @Return:
     */
    public PageInfo<Account> selectAllAcounts(int PageNum) throws Exception;
}
