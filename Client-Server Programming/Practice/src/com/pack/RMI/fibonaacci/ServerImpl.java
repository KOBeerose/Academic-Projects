package com.pack.RMI.fibonaacci;


import com.pack.RMI.hello.IHello;

import java.rmi.*;
import java.rmi.server.*;

public class ServerImpl extends UnicastRemoteObject implements IHello {
    private String message;

    public ServerImpl() throws RemoteException {
        super();
    }

    public String say() throws RemoteException {
        return "Hello Everybody!";
    }

    public static void main(String[] args) {
        //System.setSecurityManager(new SecurityManager());
        //System.setProperty("java.security.policy","file./security.policy");

        try {
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            com.pack.RMI.hello.Hello Hello = new com.pack.RMI.hello.Hello();
            Naming.rebind("rmi://localhost/google", Hello);
            System.out.println(" HelloServer bound in registry at the url ");
            System.out.println("Server is ready.");
        } catch (Exception e) {
            System.out.println("Server failed.\n" + e);
        }
    }
}