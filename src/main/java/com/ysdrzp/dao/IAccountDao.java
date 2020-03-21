package com.ysdrzp.dao;

import com.ysdrzp.model.Account;
import com.ysdrzp.model.AccountUser;

import java.util.List;

/**
 * 账户持久层接口
 */
public interface IAccountDao {

    /**
     * 查询所有账户，同时获取账户的所属用户名称以及它的地址信息
     * @return
     */
    //List<AccountUser> findAll();

    /**
     * 查询所有账户，同时获取账户的所属用户名称以及它的地址信息
     * @return
     */
    List<Account> findAll();
}
