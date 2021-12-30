package com.pack.tp2.exo1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        BankAccount c = new BankAccount(800);
        Runnable ru = new SanjiAndNamiJob(c);
        Thread Sanji = new Thread(ru);
        Thread Nami = new Thread(ru);
        Sanji.setName("Sanji");
        Nami.setName("Nami");
        Sanji.start();
        Nami.start();

    }
}
