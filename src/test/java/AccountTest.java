import com.ysdrzp.dao.IAccountDao;
import com.ysdrzp.model.Account;
import com.ysdrzp.model.AccountUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * 测试类
 */
public class AccountTest {

    private InputStream in ;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IAccountDao accountDao;

    /*@Test
    public void testFindAll() {
        //6.执行操作
        List<AccountUser> accountusers = accountDao.findAll();
        for(AccountUser au : accountusers) {
            System.out.println(au);
        }
    }*/

    @Test
    public void testFindAll() {
        List<Account> accounts = accountDao.findAll();
    }

    @Before
    public void init()throws Exception {
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建构建者对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //3.创建 SqlSession 工厂对象
        factory = builder.build(in);
        //4.创建 SqlSession 对象
        session = factory.openSession();
        //5.创建 Dao 的代理对象
        accountDao = session.getMapper(IAccountDao.class);
    }

    @After
    public void destroy() throws Exception{
        session.commit();
        //7.释放资源
        session.close();
        in.close();
    }

}
