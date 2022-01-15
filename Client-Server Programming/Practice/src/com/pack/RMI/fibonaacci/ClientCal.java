package com.pack.RMI.fibonaacci;

import com.pack.RMI.hello.IHello;

import java.rmi.Naming;

public class ClientCal {
    public static void main(String[] args) {
        System.setProperty("java.security.policy","file:./src/com/pack/RMI/hello/java.policy");
        System.setSecurityManager(new SecurityManager());

        try {
            IHello hello = (IHello) Naming.lookup("rmi://127.0.0.1/google");
            System.out.println(hello.say());
        } catch (Exception e) {
            System.out.println("ServerImpl exception: " + e);
        }
    }
}
