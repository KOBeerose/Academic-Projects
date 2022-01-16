package com.pack.RMI.fibonaacci;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Server extends Remote {
    public int fibonacci (int n) throws RemoteException;
}
