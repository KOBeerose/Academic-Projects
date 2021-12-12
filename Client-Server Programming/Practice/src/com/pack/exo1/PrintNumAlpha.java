package com.pack.exo1;

class PrintNums extends Thread {
    public void run() {
        for (int i = 1; i <= 260; i++) {
            System.out.println(i + " ");
        }
    }
}
class PrintAlpha extends Thread {
    public void run() {
        char i;
        for ( i = 'a'; i <= 'z'; i++) {
            System.out.println(i + " ");
        }
    }
}

class PrintNumAlpha {
    public static void main(String[] args) {
        PrintNums t1 = new PrintNums();
        PrintAlpha t2 = new PrintAlpha();
        t1.start();
        t2.start();
    }
}