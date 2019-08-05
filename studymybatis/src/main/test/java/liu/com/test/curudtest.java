package liu.com.test;/**
 * Created by ASUS on 2019/7/25.
 */

import liu.com.dao.IUserDao;
import liu.com.domian.QueryVo;
import liu.com.domian.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @描述 :
 * @参数: $
 * @返回值 : $
 * @创建人 : HC
 * @创建时间 : $
 * @修改人和其它信息
 */
public class curudtest {
    private  InputStream inputStream;
    private  SqlSession sqlSession;
    private IUserDao iUserDao;
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
         iUserDao=sqlSession.getMapper(IUserDao.class);
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
        List<User> users=iUserDao.findall();
        for (User user:users){
            System.out.println(user.toString());
        }
    }
    /*User保存测试*/
    @Test
    public void saveuser(){
        User user=new User();
        user.setUsername("刘亦心");
        user.setAddress("江西南昌");
        user.setBirthday(new Date());
        /*没有id*/
        System.out.println("保存操作前:"+user.toString());
        iUserDao.saveuser(user);
        /*这有id*/
        System.out.println("保存操作后:"+user.toString());
    }

    /*User更新测试*/
    @Test
    public  void updateuser(){
        User user= iUserDao.findById(3);
        user.setBirthday(new Date());
        iUserDao.updateuser(user);
    }



    /*删除测试*/
    @Test
    public void deleteeuser(){
        iUserDao.deleteuser(5);
    }
    /*根据用户的Id来查找用户*/
    @Test
    public void testfindById(){
      User user= iUserDao.findById(1);
        System.out.println(user.toString());
    }
    /*根据用户的name进行模糊查询*/
    @Test
    public void testFindByName(){
        List<User> users=iUserDao.findByName("叡");
        for (User user:users){
            System.out.println(user.toString());
        }
    }
    @Test
    public void testFindUserCount(){
     Integer count=   iUserDao.selectUserCount();
     System.out.print(count);
    }
    @Test
    /*将查询的条件封装在一个对象里*/
    public void testFindByVo(){
        QueryVo queryVo=new QueryVo();
        User user1=new User();
        user1.setUsername("叡");
        queryVo.setUser(user1);
        List<User> users= iUserDao.findUserByVo(queryVo);
        for (User user:users){
            System.out.println(user.toString());
        }
    }
    /**
     * 结果类型的封装
     */




}
