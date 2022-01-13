package com.pack.RMI.hello;

import java.rmi.*;
import java.rmi.server.*;

public class Hello extends UnicastRemoteObject implements IHello {
	private String message;

	public Hello() throws RemoteException {
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
			Hello Hello = new Hello();
			Naming.rebind("rmi://localhost/google", Hello);
		      System.out.println(" HelloServer bound in registry at the url "); 
			System.out.println("Server is ready.");
		} catch (Exception e) {
			System.out.println("Server failed.\n" + e);
		}
	}
}