package com.ysdrzp.easy;

public interface SqlSessionFactory {

    /**
     * 创建一个新的 SqlSession 对象
     * @return
     */
    SqlSession openSession();
}
