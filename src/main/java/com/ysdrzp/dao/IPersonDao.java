package com.ysdrzp.dao;

import com.ysdrzp.easy.Select;
import com.ysdrzp.model.Person;

import java.util.List;

/**
 * 持久层接口
 */
public interface IPersonDao {

    /**
     * 获取所有
     * @return
     */
    @Select("select * from person")
    List<Person> findAll();
}
