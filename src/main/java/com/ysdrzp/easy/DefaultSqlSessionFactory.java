package com.ysdrzp.easy;

import com.ysdrzp.util.XMLConfigBuilder;

import java.io.InputStream;

public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private InputStream config = null;

    public void setConfig(InputStream config) {
        this.config = config;
    }

    @Override
    public SqlSession openSession() {
        DefaultSqlSession session = new DefaultSqlSession();
        XMLConfigBuilder.loadConfiguration(session, config);
        return session;
    }

}
