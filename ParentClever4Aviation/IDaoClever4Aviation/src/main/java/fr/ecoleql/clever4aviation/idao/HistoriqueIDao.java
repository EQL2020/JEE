package fr.ecoleql.clever4aviation.idao;

import java.util.List;

import fr.ecoleql.clever4aviation.entity.ConsigneSurete;
import fr.ecoleql.clever4aviation.entity.Defaut;
import fr.ecoleql.clever4aviation.entity.Historique;

public interface HistoriqueIDao {
	
	List<Historique> getHistoriqueByDefaut(Defaut defaut);
	List<Historique> getHistoriqueByConsigne(ConsigneSurete consigne);
	Historique insertHistorique (Historique historique);
	Integer getMaxVersionByDefaut (Defaut defaut); 
	Integer getMaxVersionByConsigne (ConsigneSurete consigne); 
}
