package fr.eql.ai108.rmi.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import fr.eql.ai108.rmi.api.ICalcul;

public class ClientRmi {

	public static void main(String[] args) {
		String JNDI = "rmi://127.0.0.1:12345/toto";
		try {
			ICalcul proxy = (ICalcul) Naming.lookup(JNDI);
			System.out.println(proxy.add(40, 2));
			System.out.println(proxy.pow(10, 2));
			System.out.println(proxy.getToto().toString());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
