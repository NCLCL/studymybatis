package liu.com.dao;

import liu.com.domian.QueryVo;
import liu.com.domian.User2;

import java.util.List;

/**
 * Created by ASUS on 2019/7/26.
 */
public interface IUserDao2 {
    List<User2> findall();
    /*保存用户*/
    void saveuser(User2 User2);
    /*更新用户*/
    void updateuser(User2 User2);
    /*根据id删除用户*/
    void  deleteuser(int id);
    /*根绝id查找用户*/
    User2 findById(Integer id);
    /*根据name模糊查询*/
    List<User2> findByName(String name);
    /*查询总用户数*/
    int selectUserCount();
    /*根据封装好的一个查询对象进行查询*/
    List<User2> findUser2ByVo(QueryVo vo);
    /**
     * 根据传入的参数条件查询
     * @param  user2 查询的条件，有可能有年龄，也有可能有地址，还有有用户名，还有可能是都或者是都没有
     */
    List<User2> findUserByCondition(User2 user2);
    /*根据queryVo中提供的ids 提供子查询*/
    List<User2>findUserIds(QueryVo vo);
}
