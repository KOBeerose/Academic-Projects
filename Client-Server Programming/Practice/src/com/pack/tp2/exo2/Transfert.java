package com.pack.tp2.exo2;

public class Transfert implements Runnable {
    Bank bank;
    int sender;
    public static String key = "KEY";
    public Transfert(Bank bank, int sender, double amount) {
        this.bank = bank;
        this.sender = sender;
        this.bank.accounts[sender] = amount;
    }
    public void run() {
        while (true) {
            //synchronized(key)
            //{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            double Max = this.bank.accounts[sender];
            double Min = 1;
            double TransfertAmount = Min + (int)(Math.random() * ((Max - Min) + 1));
            int receiver = 0 + (int)(Math.random() * (100));
            while (receiver == sender) {
                receiver = 0 + (int)(Math.random() * (100));
            }
            System.out.println("Sender: " + sender + " Receiver: " + receiver + " amount: " + TransfertAmount);
            synchronized(key) {
                try {
                    bank.Transfer(sender, receiver, TransfertAmount);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Solde total: " + this.bank.TotalBalance());
            // }
        }
    }
}


