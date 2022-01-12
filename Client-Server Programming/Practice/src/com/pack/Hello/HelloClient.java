import java.rmi.*;

public class HelloClient {
	public static void main(String[] args) {
		System.setSecurityManager(new SecurityManager());
		// System.setProperty("java.security.policy","file./security.policy");

		try {
			IHello hello = (IHello) Naming.lookup("rmi://127.0.0.1/Hello");
			System.out.println(hello.say());
		} catch (Exception e) {
			System.out.println("HelloClient exception: " + e);
		}
	}
}