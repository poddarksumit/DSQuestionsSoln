package rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MyRMIClient {
	public static void main(String[] args) throws RemoteException,
			NotBoundException {
		Registry registry = LocateRegistry.getRegistry("localhost", 2222);
		RemoteInterface remote = (RemoteInterface) registry
				.lookup("GetUserMessage");
		System.out.println(remote.getMessage("Sumit. I am going good."));
	}
}
