package liu.com.test;/**
 * Created by ASUS on 2019/7/26.
 */
import liu.com.dao.IUserDao2;
import liu.com.domian.QueryVo;
import liu.com.domian.User;
import liu.com.domian.User2;
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
 * @描述 :用于测试curud
 * @参数: $
 * @返回值 : $
 * @创建人 : HC
 * @创建时间 : $
 * @修改人和其它信息
 */
public class curudtest2 {

    private InputStream inputStream;
    private SqlSession sqlSession;
    private IUserDao2 iUserDao2;
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
        /*可以设置自动提交事务*/
        /*sqlSession =sqlSessionFactory.openSession(true);*/
        /*SqlSession创建代理对象*/
        iUserDao2=sqlSession.getMapper(IUserDao2.class);
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
        List<User2> users=iUserDao2.findall();
        for (User2 user:users){
            System.out.println(user.toString());
        }
    }
    /*User保存测试*/
    @Test
    public void saveuser(){
        User2 user=new User2();
        user.setUserName("刘亦心2");
        user.setUserAddress("江西南昌");
        user.setUserBirthday(new Date());
        /*没有id*/
        System.out.println("保存操作前:"+user.toString());
        iUserDao2.saveuser(user);
        /*这有id*/
        System.out.println("保存操作后:"+user.toString());
    }
    /*User更新测试*/
    @Test
    public void updateuser(){
        User2 user=new User2();
        user.setUserId(7);
        user.setUserName("徐浩琛");
        user.setUserAddress("江西南昌");
        user.setUserBirthday(new Date());
        user.setUserAge(12);
        iUserDao2.updateuser(user);
    }
    /*User更新测试*/
    @Test
    public void deleteeuser(){
        iUserDao2.deleteuser(5);
    }
    /*根据用户的Id来查找用户*/
    @Test
    public void testfindById(){
        User2 user= iUserDao2.findById(1);
        System.out.println(user.toString());
    }
    /*根据用户的name进行模糊查询*/
    @Test
    public void testFindByName(){
        List<User2> users=iUserDao2.findByName("叡");
        for (User2 user:users){
            System.out.println(user.toString());
        }
    }
    @Test
    public void testFindUserCount(){
        Integer count=   iUserDao2.selectUserCount();
        System.out.print(count);
    }
    @Test
    /*将查询的条件封装在一个对象里*/
    public void testFindByVo(){
        QueryVo queryVo=new QueryVo();
        User2 user2=new User2();
        user2.setUserName("叡");
        queryVo.setUser2(user2);
        List<User2> users= iUserDao2.findUser2ByVo(queryVo);
        for (User2 user:users){
            System.out.println(user.toString());
        }
    }
    @Test
    public  void  testfindUserByCondition(){
        User2 user2=new User2();
        user2.setUserName("刘叡");
        user2.setUserAge(12);
        List<User2> user2s=iUserDao2.findUserByCondition(user2);
        for (User2 user21:user2s){
            System.out.println(user21);
        }

    }
    /*测试findUserIds的方法*/
    @Test
    public  void testfindUserIds(){
        QueryVo vo=new QueryVo();
        List<Integer> list=new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        vo.setIds(list);
        List<User2> user2List= iUserDao2.findUserIds(vo);
        for (User2 user1 :user2List){
            System.out.println(user1.toString());
        }

    }



}
