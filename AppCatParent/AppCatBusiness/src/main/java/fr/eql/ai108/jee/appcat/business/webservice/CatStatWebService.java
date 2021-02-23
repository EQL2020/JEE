package fr.eql.ai108.jee.appcat.business.webservice;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebService;

import fr.eql.ai108.jee.appcat.ibusiness.webservice.CatStatIWebService;
import fr.eql.ai108.jee.appcat.idao.api.UserIDao;

@WebService (targetNamespace = "http://ai108.catstat.com",
endpointInterface = "fr.eql.ai108.jee.appcat.ibusiness.webservice.CatStatIWebService",
serviceName = "CatStatService", portName = "CatStatPort")
@Remote(CatStatIWebService.class)
@Stateless
public class CatStatWebService implements CatStatIWebService {

	@EJB
	private UserIDao proxyUserDao;
	
	@Override
	public Long getNbUser() {
		Long nbUser = proxyUserDao.getNbUser();
		return nbUser;
	}
}
