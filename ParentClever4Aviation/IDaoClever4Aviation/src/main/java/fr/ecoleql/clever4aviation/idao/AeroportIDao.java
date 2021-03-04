package fr.ecoleql.clever4aviation.idao;

import java.util.List;

import fr.ecoleql.clever4aviation.entity.Aeroport;

public interface AeroportIDao {
	List<Aeroport> getAll();
	Aeroport getById(Integer id);
}
