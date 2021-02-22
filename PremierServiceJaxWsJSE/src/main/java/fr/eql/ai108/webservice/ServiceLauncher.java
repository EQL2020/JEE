package fr.eql.ai108.webservice;

import javax.xml.ws.Endpoint;

public class ServiceLauncher {

	public static void main(String[] args) {
		System.out.println("Démarrage serveur");
		String url = "http://localhost:12345/toto/titi.ai108";
		IService service = new Service();
		Endpoint.publish(url, service);
		System.out.println("Serveur Démarré");

	}

}
