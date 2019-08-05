package liu.com.test;/**
 * Created by ASUS on 2019/7/26.
 */

import liu.com.dao.IUserDao;
import liu.com.dao.impl.IUserDaoImpl;
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
public class curutestimpl {
    private InputStream inputStream;

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
        iUserDao=new IUserDaoImpl(sqlSessionFactory)
;
    }
    @After
    public  void  close () throws Exception{


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
        user.setUsername("胡杨");
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
    public void updateuser(){
        User user=new User();
        user.setId(1);
        user.setUsername("徐浩琛");
        user.setAddress("江西南昌");
        user.setBirthday(new Date());
        user.setAge(12);
        iUserDao.updateuser(user);
    }
    /*User更新测试*/
    @Test
    public void deleteuser(){
        iUserDao.deleteuser(1);
    }
    @Test
    public void findByName(){
    List<User>  users   =iUserDao.findByName("琛");
    for (User user:users){
        System.out.println(user.toString());
    }
    }
    @Test
    public  void selectUserCount(){
        int count=iUserDao.selectUserCount();
        System.out.println("查询的条数"+count);
    }


}
