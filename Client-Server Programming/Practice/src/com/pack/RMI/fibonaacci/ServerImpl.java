package com.pack.RMI.fibonaacci;


import com.pack.RMI.hello.IHello;

import java.rmi.*;
import java.rmi.server.*;

public class ServerImpl extends UnicastRemoteObject implements Server {
    private String message;

    public ServerImpl() throws RemoteException {
        super();
    }

    public int fibonacci(int n) throws RemoteException {
        int MAX = 1000;
        int f[];
        f= new int[MAX];

        if (n == 0)
            return 0;

        if (n == 1 || n == 2)
            return (f[n] = 1);

        if (f[n] != 0)
            return f[n];

        int k = (n & 1) == 1? (n + 1) / 2
                : n / 2;

        f[n] = (n & 1) == 1? (fibonacci(k) * fibonacci(k) +
                fibonacci(k - 1) * fibonacci(k - 1))
                : (2 * fibonacci(k - 1) + fibonacci(k))
                * fibonacci(k);

        return f[n];
    }

    public static void main(String[] args) {
        //System.setSecurityManager(new SecurityManager());
        //System.setProperty("java.security.policy","file./security.policy");

        try {
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            ServerImpl ServerImpl = new ServerImpl();
            Naming.rebind("rmi://localhost/fibonacci", ServerImpl);
            System.out.println(" fibonacciServer bound in registry at the url ");
            System.out.println("Server is ready.");
        } catch (Exception e) {
            System.out.println("Server failed.\n" + e);
        }
    }
}