package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyRMIClassImpl extends UnicastRemoteObject implements
		RemoteInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyRMIClassImpl() throws RemoteException {

	}

	@Override
	public String getMessage(String addOns) throws RemoteException {
		// TODO Auto-generated method stub
		return "Hello " + addOns;
	}
}
