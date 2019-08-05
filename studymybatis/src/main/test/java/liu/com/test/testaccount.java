package liu.com.test;

import liu.com.dao.IAccountDao;
import liu.com.dao.IUserDao;
import liu.com.domian.Account;
import liu.com.domian.User;
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
 * class: $
 * create by: $
 * description:
 * create time: $
 *
 * @param: $
 */

public class testaccount {
    private InputStream inputStream;
    private SqlSession sqlSession;
    private IAccountDao iAccountDao;
    @Before
    public  void  junit() throws Exception{
        /*加载mysql配置文件*/
        inputStream= Resources.getResourceAsStream("SqlMapConfig.xml");
        /*创建构建者*/
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        /*利用构建者模式创建SqlSessionFactory*/
        SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(inputStream);
        /*利用SqlSessionFactory创建SQLSession对象*/
        sqlSession=sqlSessionFactory.openSession();
        /*SqlSession创建代理对象*/
        iAccountDao=sqlSession.getMapper(IAccountDao.class);
    }
    @After
    public  void  close () throws Exception{
        sqlSession.commit();
        /*关闭Session对象*/
        sqlSession.close();
        /*关闭资源*/
        inputStream.close();
    }
    @Test
    public  void findall() throws Exception{
        List<Account> accounts =iAccountDao.findall();
        for (Account account:accounts){
            System.out.println(account.toString());
        }
    }


}
