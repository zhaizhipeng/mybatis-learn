package com.ysdrzp.util;

import com.ysdrzp.easy.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 数据库管理
 */
public class DataSourceUtil {

    /**
     * 获取连接
     * @param cfg
     * @return
     */
    public static Connection getConnection(Configuration cfg) {
        try {
            Class.forName(cfg.getDriver());
            Connection conn = DriverManager.getConnection(cfg.getUrl(),cfg.getUsername(), cfg.getPassword());
            return conn;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

