package com.pack.tp2.exo2;

public class Main {
    public static void main(String[] args) {  //Simulation :
        Bank bank = new Bank(60, 5000);
        for (int i = 0; i < 60; i++) {
            Runnable runnable = new Transfert(bank, i, 5000);
            new Thread(runnable).start();
        }
    }
}