package fr.ecoleql.clever4aviation.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.ecoleql.clever4aviation.entity.Aeroport;
import fr.ecoleql.clever4aviation.ibusiness.AeroportIBusiness;
import fr.ecoleql.clever4aviation.idao.AeroportIDao;


@Remote (AeroportIBusiness.class)
@Stateless
public class AeroportBusiness implements AeroportIBusiness {
	
	@EJB
	private AeroportIDao proxyAeroportDao;

	@Override
	public List<Aeroport> displayAllAirport() {
		// TODO Auto-generated method stub
		return proxyAeroportDao.getAll();
	}

}
