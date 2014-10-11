package rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MyRemoteServer {

	public static void main(String[] args) throws RemoteException,
			MalformedURLException, NotBoundException, AlreadyBoundException {
		Registry registry = LocateRegistry.createRegistry(2222);
		registry.bind("GetUserMessage", new MyRMIClassImpl());
		System.out.println("Server has started.");
	}
}
