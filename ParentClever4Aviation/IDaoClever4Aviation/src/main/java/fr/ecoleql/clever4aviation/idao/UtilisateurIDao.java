package fr.ecoleql.clever4aviation.idao;

import fr.ecoleql.clever4aviation.entity.Utilisateur;

public interface UtilisateurIDao {
	Utilisateur authenticate (String login, String password);
}
