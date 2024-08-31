package me.lms.tddtest.tdd.account;

public class Account {

    private int balance;

    public Account() {
        this.balance = 0;
    }

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int money) {
        if(money < 0) {
            throw new IllegalArgumentException();
        }
        balance += money;
    }

    public void withdraw(int money) {
        if(money < 0) {
            throw new IllegalArgumentException();
        }
        if(balance < money) {
            throw new IllegalStateException();
        }
        balance -= money;
    }

    public void testAccount(){
        Account account = new Account();
        if(account == null){
            try {
                throw new Exception("Account is null");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
