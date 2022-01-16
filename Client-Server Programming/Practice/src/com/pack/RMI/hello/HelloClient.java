package com.pack.RMI.hello;

import java.rmi.*;

public class HelloClient {
	public static void main(String[] args) {
		System.setProperty("java.security.policy","file:./src/com/pack/RMI/hello/java.policy");

		try {
			IHello hello = (IHello) Naming.lookup("rmi://127.0.0.1/google");
			System.out.println(hello.say());
		} catch (Exception e) {
			System.out.println("HelloClient exception: " + e);
		}
	}
}