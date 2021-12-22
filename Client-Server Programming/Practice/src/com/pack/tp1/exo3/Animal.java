package com.pack.tp1.exo3;

public class Animal extends Thread {

    private int step;
    public Animal (int step) {
        super();
        this.step = step;

    }

    public void run () {
        running();
    }
    private void running() {
        String threadName = Thread.currentThread().getName();

        int dist;
        for ( dist = 1; dist <= totalDistance; dist+=step) {
            System.out.println(threadName+" : "+dist+" m");

                if (threadName.equals("lievre") && dist == 25 ) {
                    try {

                    }
                }
        }

    }
}

