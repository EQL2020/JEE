package fr.eql.ai108.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import fr.eql.ai108.entity.Personne;

@WebService (targetNamespace = "http://ai108.microsoft.com", name = "Ai108IService")
public interface IService {
	
	@WebMethod(operationName = "addition")
	@WebResult (name = "additionResult", targetNamespace = "http://ai108.microsoft.com")
	int add(@WebParam(name = "i")int i,
			@WebParam(name="j") int j);
	
	@WebMethod (operationName = "pow")
	@WebResult (name = "powResult", targetNamespace = "http://ai108.microsoft.com")
	double pow(@WebParam(name = "a")double a,
			@WebParam(name = "b")double b);
	
	@WebMethod (operationName = "serialTest")
	@WebResult (name = "personResult")
	Personne testSerialisation(@WebParam(name = "inputPerson") Personne personne);
	
	
	
	
	
	
	
}
