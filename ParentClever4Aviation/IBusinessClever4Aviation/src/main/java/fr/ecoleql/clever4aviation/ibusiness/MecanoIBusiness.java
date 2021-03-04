package fr.ecoleql.clever4aviation.ibusiness;

import java.util.List;

import fr.ecoleql.clever4aviation.entity.Avion;
import fr.ecoleql.clever4aviation.entity.Defaut;
import fr.ecoleql.clever4aviation.entity.Historique;

public interface MecanoIBusiness {
	List<Avion> afficherAvions();
	List<Defaut> afficherDefautsParAvion(Avion avion);
	Defaut ajouterDefaut(Defaut defaut);
	Avion afficherAvionParImmatriculation(String immatriculation);
	List<Historique> afficherHistoriqueParDefaut (Defaut defaut);
	Defaut mettreAJourDefaut(Defaut defaut);
	Historique ajouterHistorique (Historique historique);
	void supprimerDefaut (Defaut defaut);
	Integer obtenirNumeroVersion(Defaut defaut);
	Integer obtenirNouvelleReferenceDefaut();
}
