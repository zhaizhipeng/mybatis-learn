import com.ysdrzp.dao.IUserDao;
import com.ysdrzp.model.QueryVo;
import com.ysdrzp.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * CRUD 测试
 */
public class MybatisCRUDTest {

    private InputStream in ;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao userDao;

    @Test
    public void testFindOne() {
        //6.执行操作
        User user = userDao.findById(41);
        System.out.println(user);
    }

    @Test
    public void testSave(){
        User user = new User();
        user.setUserName("modify User property");
        user.setAddress("北京市顺义区");
        user.setSex("男");
        user.setBirthday(new Date());
        System.out.println("保存操作之前："+user);
        int count = userDao.saveUser(user);
        System.out.println("count:" + count);
        System.out.println("保存操作之后："+user);
    }

    @Test
    public void testUpdateUser()throws Exception{
        User user = userDao.findById(1);
        user.setAddress("北京市顺义区");
        int res = userDao.updateUser(user);
        System.out.println(res);
    }

    @Test
    public void testDeleteUser() throws Exception {
        int res = userDao.deleteUser(52);
        System.out.println(res);
    }

    @Test
    public void testFindByName(){
        List<User> users = userDao.findByName("王");
        for(User user : users){
            System.out.println(user);
        }
    }

    @Test
    public void testFindTotal() {
        int res = userDao.findTotal();
        System.out.println(res);
    }

    @Test
    public void testFindByQueryVo() {
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUserName("小");
        vo.setUser(user);
        List<User> users = userDao.findByVo(vo);
        for(User u : users) {
            System.out.println(u);
        }
    }

    @Test
    public void testFindAll() {
        List<User> users = userDao.findAll();
        for(User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindByUser() {
        User u = new User();
        u.setUserName("%王%");
        u.setAddress("%顺义%");
        //6.执行操作
        List<User> users = userDao.findByUser(u);
        for(User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindInIds() {
        QueryVo vo = new QueryVo();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(41);
        ids.add(42);
        ids.add(43);
        ids.add(46);
        ids.add(57);
        vo.setIds(ids);
        //6.执行操作
        List<User> users = userDao.findInIds(vo);
        for(User user : users) {
            System.out.println(user);
        }
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
        session = factory.openSession(true);
        //5.创建 Dao 的代理对象
        userDao = session.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws Exception{
        session.commit();
        //7.释放资源
        session.close();
        in.close();
    }

}
