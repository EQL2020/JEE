package fr.ecoleql.clever4aviation.idao;

import java.util.List;

import fr.ecoleql.clever4aviation.entity.Avion;

public interface AvionIDao {
	List<Avion> getAll();
	Avion getByImmatriculation(String immatriculation);
}
