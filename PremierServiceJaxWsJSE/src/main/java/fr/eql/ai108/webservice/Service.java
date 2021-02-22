package fr.eql.ai108.webservice;

import javax.jws.WebService;

import fr.eql.ai108.entity.Personne;

@WebService (targetNamespace = "http://ai108.microsoft.com", 
endpointInterface = "fr.eql.ai108.webservice.IService",
serviceName = "Ai108Service", portName = "Ai108Port")
public class Service implements IService {

	@Override
	public int add(int i, int j) {
		// TODO Auto-generated method stub
		return i + j;
	}

	@Override
	public double pow(double a, double b) {
		// TODO Auto-generated method stub
		return Math.pow(a, b);
	}

	@Override
	public Personne testSerialisation(Personne personne) {
		personne.setName(personne.getName().toUpperCase());
		return personne;
	}

}
