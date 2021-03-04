package fr.ecoleql.clever4aviation.ibusiness;

import fr.ecoleql.clever4aviation.entity.Utilisateur;

public interface CompteIBusiness {
	Utilisateur connexion(String login, String password);
}
