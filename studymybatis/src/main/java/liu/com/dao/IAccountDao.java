package liu.com.dao;

import liu.com.domian.Account;

import java.util.List;

public interface IAccountDao {
    /*查询所有*/
    List<Account> findall();
}
