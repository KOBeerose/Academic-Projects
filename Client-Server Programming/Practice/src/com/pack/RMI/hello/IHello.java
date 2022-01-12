package com.pack.RMI.hello;

import java.rmi.*;

public interface IHello extends Remote {
	public String say() throws RemoteException;
}