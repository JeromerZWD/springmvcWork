package dao;

import entity.Account;

import java.util.List;

public interface AccountDao {
    void saveAccount(Account account);
    void deleteAccount(int id);
    void updateAccount(Account account);
    Account getById(int id);
    List<Account> getAll();

}
