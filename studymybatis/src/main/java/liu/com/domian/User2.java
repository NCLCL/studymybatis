package liu.com.domian;/**
 * Created by ASUS on 2019/7/26.
 */

import java.util.Date;

/**
 * @描述 :用于测试实体类属性与数据库列名对不上
 * @参数: $
 * @返回值 : $
 * @创建人 : HC
 * @创建时间 : $
 * @修改人和其它信息
 */
public class User2 {
    private  String userName;
    private  String userAddress;
    private  Integer userId;
    private Date userBirthday;
    private  Integer userAge;
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }



    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User2{" +
                "userName='" + userName + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userId=" + userId +
                ", userBirthday=" + userBirthday +
                ", userAge=" + userAge +
                '}';
    }
}
