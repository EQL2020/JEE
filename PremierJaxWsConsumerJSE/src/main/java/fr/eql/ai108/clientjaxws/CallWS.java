package fr.eql.ai108.clientjaxws;

import com.microsoft.ai108.Ai108IService;
import com.microsoft.ai108.Ai108Service;
import com.microsoft.ai108.Personne;

public class CallWS {

	public static void main(String[] args) {
		Ai108IService stub = new Ai108Service().getAi108Port();
		System.out.println(stub.addition(40, 2));
		System.out.println(stub.pow(10, 5));
		Personne inputPersonne = new Personne();
		inputPersonne.setIdentity(1);
		inputPersonne.setFirstname("titi");
		Personne callback = stub.serialTest(inputPersonne);
		System.out.println(callback.getFirstname());

	}

}
