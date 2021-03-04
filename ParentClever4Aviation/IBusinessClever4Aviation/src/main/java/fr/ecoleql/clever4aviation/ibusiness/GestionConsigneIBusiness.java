package fr.ecoleql.clever4aviation.ibusiness;

import java.util.List;

import fr.ecoleql.clever4aviation.entity.Aeroport;
import fr.ecoleql.clever4aviation.entity.ConsigneSurete;
import fr.ecoleql.clever4aviation.entity.Historique;
import fr.ecoleql.clever4aviation.entity.TypeConsigne;

public interface GestionConsigneIBusiness {
	List<ConsigneSurete> afficherConsigneParType(String type);
	List<Historique> afficherHistoriqueParConsigne(ConsigneSurete consigne);
	Historique ajouterHistorique (Historique historique);
	ConsigneSurete mettreAJourConsigne(ConsigneSurete consigne);
	void supprimerConsigne(ConsigneSurete consigne);
	Integer obtenirNouvelleReferenceConsigne();
	Integer obtenirNumeroVersion(ConsigneSurete consigne);
	List<Aeroport> displayAllAirport();
	Aeroport obtenirAeroportParId(Integer id);
	ConsigneSurete ajouterConsigne(ConsigneSurete consigne);
}
