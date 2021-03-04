package fr.ecoleql.clever4aviation.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.ecoleql.clever4aviation.entity.Aeroport;
import fr.ecoleql.clever4aviation.entity.ConsigneSurete;
import fr.ecoleql.clever4aviation.entity.Historique;
import fr.ecoleql.clever4aviation.ibusiness.GestionConsigneIBusiness;
import fr.ecoleql.clever4aviation.idao.AeroportIDao;
import fr.ecoleql.clever4aviation.idao.ConsigneIDao;
import fr.ecoleql.clever4aviation.idao.HistoriqueIDao;

@Remote(GestionConsigneIBusiness.class)
@Stateless
public class GestionConsigneBusiness implements GestionConsigneIBusiness {
	
	@EJB
	private ConsigneIDao proxyConsigneDao;
	
	@EJB
	private AeroportIDao proxyAeroportDao;
	
	@EJB
	private HistoriqueIDao proxyHistoriqueDao;

	@Override
	public List<ConsigneSurete> afficherConsigneParType(String type) {	
		return proxyConsigneDao.getConsigneByType(type);
	}

	@Override
	public List<Historique> afficherHistoriqueParConsigne(ConsigneSurete consigne) {
		return proxyHistoriqueDao.getHistoriqueByConsigne(consigne);
	}

	@Override
	public ConsigneSurete mettreAJourConsigne(ConsigneSurete consigne) {
		return proxyConsigneDao.updateConsigne(consigne);
	}

	@Override
	public void supprimerConsigne(ConsigneSurete consigne) {
		proxyConsigneDao.deleteConsigne(consigne);
		
	}

	@Override
	public Integer obtenirNouvelleReferenceConsigne() {
		// TODO Auto-generated method stub
		return proxyConsigneDao.getLastConsigneReference() +1;
	}

	@Override
	public Integer obtenirNumeroVersion(ConsigneSurete consigne) {
		// TODO Auto-generated method stub
		return proxyHistoriqueDao.getMaxVersionByConsigne(consigne);
	}

	@Override
	public List<Aeroport> displayAllAirport() {
		return proxyAeroportDao.getAll();
	}

	@Override
	public Historique ajouterHistorique(Historique historique) {
		// TODO Auto-generated method stub
		return proxyHistoriqueDao.insertHistorique(historique);
	}

	@Override
	public Aeroport obtenirAeroportParId(Integer id) {
		// TODO Auto-generated method stub
		return proxyAeroportDao.getById(id);
	}

	@Override
	public ConsigneSurete ajouterConsigne(ConsigneSurete consigne) {
		// TODO Auto-generated method stub
		return proxyConsigneDao.insertConsigne(consigne);
	}

}
