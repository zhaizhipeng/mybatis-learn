package com.ysdrzp.dao;

import com.ysdrzp.model.Role;

import java.util.List;

/**
 * 角色持久层
 */
public interface IRoleDao {

    /**
     * 查询所有角色
     * @return
     */
    List<Role> findAll();
}
