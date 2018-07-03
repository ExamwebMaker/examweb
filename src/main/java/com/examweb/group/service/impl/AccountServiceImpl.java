package com.examweb.group.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.examweb.group.entity.Account;
import com.examweb.group.mapper.AccountMapper;
import com.examweb.group.service.AccountService;
import org.springframework.stereotype.Service;

/**
 * @Author: Jessiecaicai
 * @Description:
 * @Date:Created in 2018/7/3
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper,Account> implements AccountService{

}
