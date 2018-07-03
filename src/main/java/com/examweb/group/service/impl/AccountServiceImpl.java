package com.examweb.group.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.examweb.group.entity.Account;
import com.examweb.group.mapper.AccountMapper;
import com.examweb.group.service.AccountService;
import com.examweb.group.utils.ResultUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Author: Jessiecaicai
 * @Description:
 * @Date:Created in 2018/7/3
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper,Account> implements AccountService{

    @Resource
    private AccountMapper accountMapper;


    /**
     * @Description: 根据name和password判断账号是否存在
     * @Json:
     * @Date: 2018/7/3
     * @Return:
     */
    @Override
    @Transactional
    public Integer checkAccoutIsExist(String name, String password) throws Exception{
        Account account=accountMapper.getAccountByNameAndPassword(name,password);
        try {
            if (account!=null){
                return 0;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public Account getAccountByNameAndPassword(String name,String password){
        Account account=accountMapper.getAccountByNameAndPassword(name,password);
        return account;
    }

    @Override
    public Account getAccountByName(String name){
        Account account=accountMapper.getAccountByName(name);
        return account;
    }

}
