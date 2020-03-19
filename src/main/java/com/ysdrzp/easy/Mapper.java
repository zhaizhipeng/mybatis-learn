package com.ysdrzp.easy;

/**
 * Mapper
 * 用于封装查询时的必要信息：要执行的 SQL 语句和实体类的全限定类名
 */
public class Mapper {

    /**
     * sql 语句
     */
    private String queryString;

    /**
     * 结果类型的全限定类名
     */
    private String resultType;

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
