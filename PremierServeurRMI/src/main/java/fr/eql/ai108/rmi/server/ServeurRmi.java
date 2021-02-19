package fr.eql.ai108.rmi.server;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import fr.eql.ai108.rmi.api.ICalcul;
import fr.eql.ai108.rmi.impl.Calcul;

public class ServeurRmi {

	public static void main(String[] args) {
		try {
			//On ouvre un port d'écoute sur notre JVM
			LocateRegistry.createRegistry(12345);
			//On instancie notre objet distant
			ICalcul objDistant = new Calcul();
			//On publie notre objet distant à une jndi donnée
			Naming.bind("rmi://127.0.0.1:12345/toto", objDistant);
			System.out.println("Objet distant déposé ici : rmi://127.0.0.1:12345/toto");
		} catch (RemoteException | MalformedURLException | AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
