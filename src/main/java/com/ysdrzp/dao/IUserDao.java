package com.ysdrzp.dao;

import com.ysdrzp.model.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 持久层操作
 */
public interface IUserDao {

    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
    List<User> findAll();
}
