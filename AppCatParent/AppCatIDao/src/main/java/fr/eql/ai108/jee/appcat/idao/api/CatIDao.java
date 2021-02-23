package fr.eql.ai108.jee.appcat.idao.api;

import java.util.List;

import fr.eql.ai108.jee.appcat.entity.Cat;

public interface CatIDao extends GenericIDao<Cat> {
	List<Cat> getAll();
	Long getNbCat();
}
