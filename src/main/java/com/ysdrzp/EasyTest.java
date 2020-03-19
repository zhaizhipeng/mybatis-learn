package com.ysdrzp;

import com.ysdrzp.dao.IPersonDao;
import com.ysdrzp.dao.IUserDao;
import com.ysdrzp.easy.Resources;
import com.ysdrzp.easy.SqlSession;
import com.ysdrzp.easy.SqlSessionFactory;
import com.ysdrzp.easy.SqlSessionFactoryBuilder;
import com.ysdrzp.model.Person;
import com.ysdrzp.model.User;

import java.io.InputStream;
import java.util.List;

/**
 * 自定义 Mybatis 框架测试
 */
public class EasyTest {

    public static void main(String[] args)throws Exception {
        // 1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建 SqlSessionFactory 的构建者对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //3.使用构建者创建工厂对象 SqlSessionFactory
        SqlSessionFactory factory = builder.build(in);
        //4.使用 SqlSessionFactory 生产 SqlSession 对象
        SqlSession session = factory.openSession();
        //5.使用 SqlSession 创建 dao 接口的代理对象
        IPersonDao personDao = session.getMapper(IPersonDao.class);
        //6.使用代理对象执行查询所有方法
        List<Person> persons = personDao.findAll();
        for(Person person : persons) {
            System.out.println(person);
        }
        //7.释放资源
        session.close();
        in.close();
    }

}
