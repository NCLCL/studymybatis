package liu.com.test;
import liu.com.dao.IUserDao;
import liu.com.domian.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
/**
 * Created by ASUS on 2019/7/9.
 */
public class MybatisTest {
    public static void  main(String[] arges) throws Exception{
        /*读取配置文件*/
        InputStream inputStream= org.apache.ibatis.io.Resources.getResourceAsStream("SqlMapConfig.xml");
        /*创建SqlSsessionFactory工厂*/
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(inputStream);
        /*使用工厂产生Sqlsession*/
        SqlSession sqlSession=factory.openSession();
        /*SqlSession创建Dao接口对象*/
        IUserDao userDao=sqlSession.getMapper(IUserDao.class);
        /*使用代理对象执行方法*/
        userDao.findall();
        List<User> users=userDao.findall();
        for (User user:users){
            System.out.println(user.getUsername());
        }
        /*释放资源*/
        sqlSession.close();
        inputStream.close();
    }

    /*加载配置文件*/
    @Test
    public  void  mytest() throws Exception {
        /*加载mysql的配置文件*/
        InputStream inputStream= Resources.getResourceAsStream("sqlMapConfig.xml");
        /*创建SQLSessionFactory对象*/
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        /*使用构建者模式创建SqlSessionFactory对象*/
        SqlSessionFactory sqlSessionFactory=builder.build(inputStream);
        /*通过sessionFactory创建session对象*/
        SqlSession sqlSession=sqlSessionFactory.openSession();
        /*使用sqlsession创建IUserDao的代理对象*/
       IUserDao iUserDao= sqlSession.getMapper(IUserDao.class);
       /*通过代理对象调用法*/
    List<User>users= iUserDao.findall();
       for (User user:users)
       sqlSession.close();
       inputStream.close();
    }
    @Test
    public void  mytest2() throws Exception{

        /*加载sqlMapConfig配置文件*/
        InputStream inputStream=Resources.getResourceAsStream("SqlMapConfig.xml");
        /*创建工厂的构建者*/
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        /*通过构建者模式创建SqlSessionFactory*/
        SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(inputStream);
        /*通过SQLSessionFactory创建SqlSession对象*/
        SqlSession sqlSession=sqlSessionFactory.openSession();
        /*利用SqlSession创建代理对象*/
        IUserDao iUserDao=sqlSession.getMapper(IUserDao.class);
        /*通过代理对象执行方法*/
        List<User> users=iUserDao.findall();
        for (User user:users){
            System.out.println(user.toString());
        }
        /*关闭SqlSession*/
        sqlSession.close();
        /*关闭加载资源*/
        inputStream.close();

    }
    @Test
    public void mytest3() throws Exception{
        /*加载mysqlmysql配置文件*/
        InputStream inputStream=Resources.getResourceAsStream("SqlMapConfig.xml");
        /*创建构建者*/
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        /*利用构建者模式创建SQLSessionFactory*/
        SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(inputStream);
        /*利用SQLSessionFactory创建SQLSession对象*/
        SqlSession sqlSession=sqlSessionFactory.openSession();
        /*利用SQLSession对象创建IUser的代理对象*/
        IUserDao iUserDao= sqlSession.getMapper(IUserDao.class);
        /*利用代理对象调用方法*/
        List<User> users =iUserDao.findall();
        for (User user:users){
            System.out.println(user.toString());

        }
        sqlSession.close();
        inputStream.close();

    }

    @Test
    public void test4() throws Exception{
        /*加载mysql配置文件*/
        InputStream inputStream=Resources.getResourceAsStream("SqlMapConfig.xml");
        /*创建构建者*/
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        /*利用构建者模式创建SqlSessionFactory*/
        SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(inputStream);
        /*利用SqlSessionFactory创建SQLSession对象*/
        SqlSession sqlSession=sqlSessionFactory.openSession();
        /*SqlSession创建代理对象*/
        IUserDao iUserDao=sqlSession.getMapper(IUserDao.class);
        List<User> users=iUserDao.findall();
        for (User user:users){
            System.out.println(user.toString());
        }
        /*关闭Session对象*/
        sqlSession.close();
        /*关闭资源*/
        inputStream.close();


    }






}
