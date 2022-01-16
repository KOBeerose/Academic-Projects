package com.pack.RMI.fibonaacci;

import com.pack.RMI.hello.IHello;

import java.rmi.Naming;

public class ClientCal {
    public static void main(String[] args) {
        System.setProperty("java.security.policy","file:./src/com/pack/RMI/fibonaacci/java.policy");

        try {
            Server serverip = (Server) Naming.lookup("rmi://127.0.0.1/fibonacci");
            System.out.println(serverip.fibonacci(9));
        } catch (Exception e) {
            System.out.println("ServerImpl exception: " + e);
        }
    }
}
