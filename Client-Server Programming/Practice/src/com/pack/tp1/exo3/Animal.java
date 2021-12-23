package com.pack.tp1.exo3;

public class Animal extends Thread {
    float speed;
    String name;

    public Animal(float speed, String name) {
        this.speed = speed;
        this.name = name;
    }

    public void run() {
        int distance = 0;
        Boolean s = false;
        while (distance < 50) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            distance += speed;
            System.out.println(this.name + " has crossed " + distance + " units");
            if (this.name == "Hare" && distance >= 25 && s == false) {
                try {
                    Thread.sleep(100000);
                    s = true;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("The " + this.name + " has arrived");
    }
}
