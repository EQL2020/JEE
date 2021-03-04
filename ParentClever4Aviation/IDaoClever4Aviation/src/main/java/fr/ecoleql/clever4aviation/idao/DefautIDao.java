package fr.ecoleql.clever4aviation.idao;

import java.util.List;

import fr.ecoleql.clever4aviation.entity.Avion;
import fr.ecoleql.clever4aviation.entity.Defaut;

public interface DefautIDao {
	List<Defaut> getDefautsByAvion(Avion avion);
	Defaut insertDefaut(Defaut defaut);
	Defaut updateDefaut (Defaut defaut);
	void deleteDefaut (Defaut defaut);
	Integer getLastDefautReference();
}
