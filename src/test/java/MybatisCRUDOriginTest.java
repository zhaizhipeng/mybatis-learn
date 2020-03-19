import com.ysdrzp.dao.IUserDao;
import com.ysdrzp.dao.impl.UserDaoImpl;
import com.ysdrzp.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * 传统DAO方式测试
 */
public class MybatisCRUDOriginTest {

    private InputStream in ;

    private SqlSessionFactory factory;

    private IUserDao userDao;

    @Test
    public void testFindAll() {
        List<User> users = userDao.findAll();
        for(User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindOne() {
        User user = userDao.findById(56);
        System.out.println(user);
    }

    @Test
    public void testSaveUser() throws Exception {
        User user = new User();
        user.setUserName("mybatis dao user");
        int res = userDao.saveUser(user);
        System.out.println(res);
        System.out.println(user.getId());
    }

    @Test
    public void testUpdateUser()throws Exception{
        User user = userDao.findById(41);
        user.setAddress("北京市顺义区");
        int res = userDao.updateUser(user);
        System.out.println(res);
    }

    @Test
    public void testDeleteUser() throws Exception {
        int res = userDao.deleteUser(56);
        System.out.println(res);
    }

    @Test
    public void testFindTotal() throws Exception {
        int res = userDao.findTotal();
        System.out.println(res);
    }

    @Before
    public void init()throws Exception {
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建构建者对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //3.创建 SqlSession 工厂对象
        factory = builder.build(in);
        //4.创建 Dao 接口的实现类
        userDao = new UserDaoImpl(factory);
    }

    @After//在测试方法执行完成之后执行
    public void destroy() throws Exception{
        //7.释放资源
        in.close();
    }

}
