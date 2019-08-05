package liu.com.domian;

import java.io.Serializable;

/**
 * class: $
 * create by: $
 * description:
 * create time: $
 *
 * @param: $
 */

public class Account implements Serializable {
    private  Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private  Integer uId;
    private  Double money;
    private  User user;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", uId=" + uId +
                ", money=" + money +
                ", user=" + user +
                '}';
    }
}
