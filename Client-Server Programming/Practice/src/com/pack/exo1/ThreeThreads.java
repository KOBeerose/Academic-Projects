package com.pack.exo1;

class PrintAlphs implements Runnable {
    private char char1;
    private char char2;

    public PrintAlphs(char char1 , char char2){
        this.char1 = char1;
        this.char2 = char2;
    }
    public void run() {
        char i;
        for ( i = char1; i <= char2; i++) {
            System.out.println(i + " ");
        }
    }
}

class ThreeThreads {
    public static void main(String[] args) {
        PrintNums t1 = new PrintNums();
        Runnable t2 = new PrintAlphs('r','z');
        Runnable t3 = new PrintAlphs('A','Q');
        t1.start();
        new Thread(t2).start();
        new Thread(t3).start();
    }
}