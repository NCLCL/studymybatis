package liu.com.domian;/**
 * Created by ASUS on 2019/7/26.
 */
import java.util.List;
/**
 * @描述 :用于封装查询条件的类
 * @参数: $
 * @返回值 : $
 * @创建人 : HC
 * @创建时间 : $
 * @修改人和其它信息
 */
public class QueryVo {
    private  User user;
    private  User2 user2;
    private List<Integer> ids;
    public User2 getUser2() {
        return user2;
    }

    public void setUser2(User2 user2) {
        this.user2 = user2;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}

