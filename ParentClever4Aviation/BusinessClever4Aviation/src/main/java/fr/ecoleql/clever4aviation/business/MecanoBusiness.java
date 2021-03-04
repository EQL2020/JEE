package fr.ecoleql.clever4aviation.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.ecoleql.clever4aviation.entity.Avion;
import fr.ecoleql.clever4aviation.entity.Defaut;
import fr.ecoleql.clever4aviation.entity.Historique;
import fr.ecoleql.clever4aviation.ibusiness.MecanoIBusiness;
import fr.ecoleql.clever4aviation.idao.AvionIDao;
import fr.ecoleql.clever4aviation.idao.DefautIDao;
import fr.ecoleql.clever4aviation.idao.HistoriqueIDao;


@Remote(MecanoIBusiness.class)
@Stateless
public class MecanoBusiness implements MecanoIBusiness {

	@EJB
	private AvionIDao proxyAvionDao;
	
	@EJB
	private DefautIDao proxyDefautDao;
	
	@EJB
	private HistoriqueIDao proxyHistoriqueDao;
	
	
	@Override
	public List<Avion> afficherAvions() {
		return proxyAvionDao.getAll();
	}

	@Override
	public List<Defaut> afficherDefautsParAvion(Avion avion) {
		// TODO Auto-generated method stub
		return proxyDefautDao.getDefautsByAvion(avion);
	}

	@Override
	public Defaut ajouterDefaut(Defaut defaut) {
		// TODO Auto-generated method stub
		return proxyDefautDao.insertDefaut(defaut);
	}

	@Override
	public Avion afficherAvionParImmatriculation(String immatriculation) {
		// TODO Auto-generated method stub
		return proxyAvionDao.getByImmatriculation(immatriculation);
	}

	@Override
	public List<Historique> afficherHistoriqueParDefaut(Defaut defaut) {
		// TODO Auto-generated method stub
		return proxyHistoriqueDao.getHistoriqueByDefaut(defaut);
	}

	@Override
	public Defaut mettreAJourDefaut(Defaut defaut) {
		// TODO Auto-generated method stub
		return proxyDefautDao.updateDefaut(defaut);
	}

	@Override
	public Historique ajouterHistorique(Historique historique) {
		// TODO Auto-generated method stub
		return proxyHistoriqueDao.insertHistorique(historique);
	}

	@Override
	public void supprimerDefaut(Defaut defaut) {
		proxyDefautDao.deleteDefaut(defaut);
		
	}

	@Override
	public Integer obtenirNumeroVersion(Defaut defaut) {
		Integer numVersion = proxyHistoriqueDao.getMaxVersionByDefaut(defaut) + 1;
		return numVersion;
	}

	@Override
	public Integer obtenirNouvelleReferenceDefaut() {
		// TODO Auto-generated method stub
		return proxyDefautDao.getLastDefautReference() + 1;
	}
}
