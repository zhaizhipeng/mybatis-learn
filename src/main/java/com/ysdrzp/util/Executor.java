package com.ysdrzp.util;

import com.mysql.jdbc.PreparedStatement;
import com.ysdrzp.easy.Mapper;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * 执行器：负责执行 sql 语句， 完成结果封装
 */
public class Executor {

    /**
     * 执行查询语句
     * @param mapper
     * @param conn
     * @param <E>
     * @return
     */
    public <E> List<E> selectList(Mapper mapper, Connection conn) {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            String queryString = mapper.getQueryString();
            String resultType = mapper.getResultType();
            Class domainClass = Class.forName(resultType);
            pstm = (PreparedStatement) conn.prepareStatement(queryString);
            rs = pstm.executeQuery();

            // 封装结果集
            List<E> list = new ArrayList<E>();
            while(rs.next()) {
                E obj = (E)domainClass.newInstance();
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnCount = rsmd.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = rsmd.getColumnName(i);
                    Object columnValue = rs.getObject(columnName);
                    //这里要求：实体类的属性和数据库表的列名保持一致
                    PropertyDescriptor pd = new PropertyDescriptor(columnName,domainClass);
                    //获取它的写入方法
                    Method writeMethod = pd.getWriteMethod();
                    //把获取的列的值，给对象赋值
                    writeMethod.invoke(obj,columnValue);
                }
                list.add(obj);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            release(pstm,rs);
        }
    }

    /**
     * 释放资源
     * @param pstm
     * @param rs
     */
    private void release(PreparedStatement pstm, ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        if(pstm != null){
            try {
                pstm.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
