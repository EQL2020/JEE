package fr.ecoleql.clever4aviation.idao;

import java.util.List;

import fr.ecoleql.clever4aviation.entity.ConsigneSurete;
import fr.ecoleql.clever4aviation.entity.Historique;
import fr.ecoleql.clever4aviation.entity.Vol;

public interface ConsigneIDao {
	
	List<ConsigneSurete> getConsigneByType(String type);
	ConsigneSurete insertConsigne(ConsigneSurete consigne);
	ConsigneSurete updateConsigne(ConsigneSurete consigne);
	void deleteConsigne(ConsigneSurete consigne);
	Integer getLastConsigneReference();
	List<ConsigneSurete> getConsigneByVol(Vol vol);
	

}
