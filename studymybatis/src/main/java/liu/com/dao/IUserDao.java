package liu.com.dao;

import liu.com.domian.QueryVo;
import liu.com.domian.User;

import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * Created by ASUS on 2019/7/23.
 */
public interface IUserDao {
    List<User> findall();
    /*保存用户*/
    void saveuser(User user);
    /*更新用户*/
    void updateuser(User user);
    /*根据id删除用户*/
    void  deleteuser(int id);
    /*根绝id查找用户*/
    User findById(Integer id);
    /*根据name模糊查询*/
    List<User> findByName(String name);
    /*查询总用户数*/
    int selectUserCount();
    /*根据封装好的一个查询对象进行查询*/
    List<User> findUserByVo(QueryVo vo);


}
