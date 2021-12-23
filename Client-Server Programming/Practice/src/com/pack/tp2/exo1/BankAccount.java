package com.pack.tp2.exo1;

public class BankAccount {
    int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    void withdraw(int s) {
        this.balance -= s;
    }
}
