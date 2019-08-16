package entity;

public class Account {
    private int id;
    private String username;
    private int balance;

    public Account() { }

    public Account(int id, String username, int balance) {
        this.id = id;
        this.username = username;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balabce) {
        this.balance = balabce;
    }

    @Override
    public String toString() {
        return "account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", balabce=" + balance +
                '}';
    }
}
