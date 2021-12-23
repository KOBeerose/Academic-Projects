package com.pack.tp2.exo1;

public class SanjiAndNamiJob implements Runnable{

    BankAccount account;

    public SanjiAndNamiJob(BankAccount account) {
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ": I wanna withdraw 100dhs");
            WithdrawRequest(100);
            if (this.account.balance <= 0)
                System.out.println("overdraft account!");
        }
    }

    public void WithdrawRequest(int balance) {
        if (this.account.getBalance() >= balance) {
            System.out.println(Thread.currentThread().getName() + " is about to withdraw.");
            System.out.println(Thread.currentThread().getName() + " asleep");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " awake");
            account.withdraw(balance);
            System.out.println(Thread.currentThread().getName() + " has finished withdrawing");
        } else
            System.out.println("there isn't enough money to " + Thread.currentThread().getName());
    }
}

