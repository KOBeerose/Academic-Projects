package com.pack.tp2.exo2;

public class Bank {
    int accountsNumber;
    final double[] accounts;

    public Bank(int accountsNumber, double balance) {
        accounts = new double[accountsNumber];
        for (int i = 0; i < accounts.length; i++) accounts[i] = balance;
    }

    public double TotalBalance() {
        double total = 0;
        for (int i=0; i<accounts.length; i++) total += accounts[i];
        return total;
    }

    public void Transfer(int sender ,int receiver, double amount) throws InterruptedException {
        if ( amount < accounts[sender] ) {
            accounts[sender] -= amount;
            Thread.sleep(500);
            accounts[receiver] += amount;
        }
    }


}
