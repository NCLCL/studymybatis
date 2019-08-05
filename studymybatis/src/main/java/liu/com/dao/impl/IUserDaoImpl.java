package liu.com.dao.impl;/**
 * Created by ASUS on 2019/7/26.
 */

import liu.com.dao.IUserDao;
import liu.com.domian.QueryVo;
import liu.com.domian.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;
/**
 * @描述 :
 * @参数: $
 * @返回值 : $
 * @创建人 : HC
 * @创建时间 : $
 * @修改人和其它信息
 */
public class IUserDaoImpl implements IUserDao{
    private SqlSessionFactory factory;
    public IUserDaoImpl(SqlSessionFactory factory){
        this.factory=factory;

    }
    @Override
    public List<User> findall() {
        /*根据SqlSessionFatory获取Session对象*/
        SqlSession sqlSession=factory.openSession();
        /*获取到配置信息的key*/
        /*这里的参数就是dao层的全限定类名以及下面的方法名*/
        List<User> users= sqlSession.selectList("liu.com.dao.IUserDao.findall");
        sqlSession.close();
        return users;
    }
    @Override
    public void saveuser(User user) {
        SqlSession sqlSession=factory.openSession();
        sqlSession.insert("liu.com.dao.IUserDao.saveuser",user);
        sqlSession.commit();
        sqlSession.close();

    }
    @Override
    public void updateuser(User user) {
        SqlSession sqlSession=factory.openSession();
        sqlSession.update("liu.com.dao.IUserDao.updateuser",user);
        sqlSession.commit();
        sqlSession.close();

    }
    @Override
    public void deleteuser(int id) {
        SqlSession sqlSession=factory.openSession();
        sqlSession.delete("liu.com.dao.IUserDao.deleteuser",id);
        sqlSession.commit();
        sqlSession.close();

    }
    @Override
    public User findById(Integer id) {
        SqlSession sqlSession=factory.openSession();
       User user= sqlSession.selectOne("liu.com.dao.IUserDao.findById",id);
        return user;
    }
    @Override
    public List<User> findByName(String name) {
        SqlSession sqlSession=factory.openSession();
       List<User> users= sqlSession.selectList("liu.com.dao.IUserDao.findByName",name);
        return users;
    }
    @Override
    public int selectUserCount() {
        SqlSession sqlSession=factory.openSession();
        int count= sqlSession.selectOne("liu.com.dao.IUserDao.selectUserCount");
        return count;
    }
    @Override
    public List<User> findUserByVo(QueryVo vo) {
        return null;
    }
}
