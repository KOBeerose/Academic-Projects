package com.pack.tp2.exo2;

public class Transfert implements Runnable {
    Bank bank;
    int depuis;
    public static String key = "KEY";
    public Transfert(Bank banque, int depuis, double amount) {
        this.bank = banque;
        this.depuis = depuis;
        this.bank.accounts[depuis] = amount;
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
            double Max = this.bank.accounts[depuis];
            double Min = 1;
            double montantTransfert = Min +
                    (int)(Math.random() * ((Max - Min) + 1));
            int destinataire = 0 + (int)(Math.random() * (100));
            while (destinataire == depuis) {
                destinataire = 0 + (int)(Math.random() * (100));
            }
            System.out.println("emetteur :" + depuis + " destinataire: " + destinataire + " montant: " + montantTransfert);
            synchronized(key) {
                try {
                    bank.Transfer(depuis, destinataire, montantTransfert);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Solde total: " + this.bank.soldeTotal());
            // }
        }
    }
}


