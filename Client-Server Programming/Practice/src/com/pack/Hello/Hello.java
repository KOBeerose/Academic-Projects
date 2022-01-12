import java.rmi.*;
import java.rmi.server.*;

public class Hello extends UnicastRemoteObject implements IHello {
	private String message;

	public Hello() throws RemoteException {
		super();
	}

	public String say() throws RemoteException {
		return "Hello World";
	}

	public static void main(String[] args) {
		//System.setSecurityManager(new SecurityManager());
		System.setProperty("java.security.policy","file./security.policy");

		try {
			java.rmi.registry.LocateRegistry.createRegistry(2030);
			Hello Hello = new Hello();
			Naming.rebind("rmi://localhost/ABC", Hello);
		      System.out.println(" HelloServer bound in registry at the url "); 
			System.out.println("Server is ready.");
		} catch (Exception e) {
			System.out.println("Server failed.\n" + e);
		}
	}
}