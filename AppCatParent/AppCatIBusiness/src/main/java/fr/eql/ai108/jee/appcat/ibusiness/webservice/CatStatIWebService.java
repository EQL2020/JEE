package fr.eql.ai108.jee.appcat.ibusiness.webservice;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService (targetNamespace = "http://ai108.catstat.com", name = "CatStatIService")
public interface CatStatIWebService {
	@WebMethod (operationName = "getNbUser")
	@WebResult (name = "nbUser", targetNamespace = "http://ai108.catstat.com")
	Long getNbUser();
}
