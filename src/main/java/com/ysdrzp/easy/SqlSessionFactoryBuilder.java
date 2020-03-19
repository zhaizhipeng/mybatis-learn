package com.ysdrzp.easy;

import java.io.InputStream;

/**
 *
 */
public class SqlSessionFactoryBuilder {

    /**
     * 根据传入的流，实现对 SqlSessionFactory 的创建
     * @param in 它就是 SqlMapConfig.xml 的配置以及里面包含的 IUserDao.xml 的配置
     * @return
     */
    public static SqlSessionFactory build(InputStream in) {

        DefaultSqlSessionFactory factory = new DefaultSqlSessionFactory();
        factory.setConfig(in);
        return factory;
    }
}
