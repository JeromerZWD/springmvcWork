package dao.impl;

import dao.AccountDao;
import entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void saveAccount(Account account) {
        String sql="insert into account1(username,balance) values(?,?)";
        int x=jdbcTemplate.update(sql,account.getUsername(),account.getBalance());
        if (x>0){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }
    }

    @Override
    public void deleteAccount(int id) {
        String sql="delete from account1 where id=?";
        int x=jdbcTemplate.update(sql,id);
        if (x>0){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
    }

    @Override
    public void updateAccount(Account account) {
        String sql="update account1 set username=?,balance=? where id=?";
        int x=jdbcTemplate.update(sql,account.getUsername(),account.getBalance(),account.getId());
        if (x>0){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
    }

    @Override
    public Account getById(int id) {
        Account account1;
        String sql="select * from account1 where id=?";
        try{
            account1=jdbcTemplate.queryForObject(sql, new RowMapper<Account>() {
                @Override
                public Account mapRow(ResultSet resultSet, int i) throws SQLException {
                    Account account=new Account();
                    account.setId(resultSet.getInt("id"));
                    account.setUsername(resultSet.getString("username"));
                    account.setBalance(resultSet.getInt("balance"));
                    return account;
                }
            },id);
        }catch (Exception e){
        return null;
        }
        return account1;
    }

    @Override
    public List<Account> getAll() {
        String sql="select * from account1";
        List<Account> list=jdbcTemplate.query(sql, new RowMapper<Account>() {
            @Override
            public Account mapRow(ResultSet resultSet, int i) throws SQLException {
                Account account=new Account();
                account.setId(resultSet.getInt("id"));
                account.setUsername(resultSet.getString("username"));
                account.setBalance(resultSet.getInt("balance"));
                return account;
            }
        });
        return list;
    }
}
