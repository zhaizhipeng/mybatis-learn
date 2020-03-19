package com.ysdrzp.easy;

import java.util.Map;

/**
 * 核心配置类
 * 1、数据库信息
 * 2、sql 的 map 集合
 */
public class Configuration {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 地址
     */
    private String url;

    /**
     * 驱动
     */
    private String driver;

    /**
     *  map 集合 Map<唯一标识，Mapper> 用于保存映射文件中的 sql 标识及 sql 语句
     */
    private Map<String, Mapper> mappers;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public Map<String, Mapper> getMappers() {
        return mappers;
    }

    public void setMappers(Map<String, Mapper> mappers) {
        this.mappers = mappers;
    }

}
