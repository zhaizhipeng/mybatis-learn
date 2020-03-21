package com.ysdrzp.dao.impl;

import com.ysdrzp.dao.IUserDao;
import com.ysdrzp.model.Account;
import com.ysdrzp.model.QueryVo;
import com.ysdrzp.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements IUserDao {

    private SqlSessionFactory factory;
    
    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }
    
    @Override
    public List<User> findAll() {
        SqlSession session = factory.openSession();
        List<User> users = session.selectList("com.ysdrzp.dao.IUserDao.findAll");
        session.close();
        return users;
    }

    @Override
    public User findById(Integer userId) {
        SqlSession session = factory.openSession();
        User user = session.selectOne("com.ysdrzp.dao.IUserDao.findById",userId);
        session.close();
        return user;
    }
    
    @Override
    public int saveUser(User user) {
        SqlSession session = factory.openSession();
        int res = session.insert("com.ysdrzp.dao.IUserDao.saveUser",user);
        session.commit();
        session.close();
        return res;
    }
    
    @Override
    public int updateUser(User user) {
        SqlSession session = factory.openSession();
        int res = session.update("com.ysdrzp.dao.IUserDao.updateUser",user);
        session.commit();
        session.close();
        return res;
    }
    
    @Override
    public int deleteUser(Integer userId) {
        SqlSession session = factory.openSession();
        int res = session.delete("com.ysdrzp.dao.IUserDao.deleteUser",userId);
        session.commit();
        session.close();
        return res;
    }

    @Override
    public int findTotal() {
        SqlSession session = factory.openSession();
        int res = session.selectOne("com.ysdrzp.dao.IUserDao.findTotal");
        session.close();
        return res;
    }

    @Override
    public List<User> findByName(String username) {
        return null;
    }

    @Override
    public List<User> findByVo(QueryVo vo) {
        return null;
    }

    @Override
    public List<User> findByUser(User user) {
        return null;
    }

    @Override
    public List<User> findInIds(QueryVo vo) {
        return null;
    }
}
