package fr.ecoleql.clever4aviation.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.ecoleql.clever4aviation.entity.ConsigneSurete;
import fr.ecoleql.clever4aviation.entity.Defaut;
import fr.ecoleql.clever4aviation.entity.Vol;
import fr.ecoleql.clever4aviation.ibusiness.GestionDossierVolIBusiness;
import fr.ecoleql.clever4aviation.idao.ConsigneIDao;
import fr.ecoleql.clever4aviation.idao.DefautIDao;
import fr.ecoleql.clever4aviation.idao.VolIDao;

@Remote(GestionDossierVolIBusiness.class)
@Stateless
public class GestionDossierVolBusiness implements GestionDossierVolIBusiness {

	@EJB
	private VolIDao proxyVolDao;
	
	@EJB
	private ConsigneIDao proxyConsigneDao;
	
	@EJB
	private DefautIDao proxyDefautDao;
	
	@Override
	public List<ConsigneSurete> afficherConsignesParVol(Vol vol) {
		// TODO Auto-generated method stub
		return proxyConsigneDao.getConsigneByVol(vol);
	}

	@Override
	public List<Defaut> afficherDefautParVol(Vol vol) {
		// TODO Auto-generated method stub
		return proxyDefautDao.getDefautsByAvion(vol.getAvion());
	}

	@Override
	public List<Vol> afficherTousLesVols() {
		// TODO Auto-generated method stub
		return proxyVolDao.getAll();
	}

}
