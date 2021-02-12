package fr.eql.ai108.dao;

import java.util.List;

public interface IDaoCat {	
	void addCat(Cat cat);
	List<Cat> findByName(String name);
	List<Cat> getAll();
	List<Cat> getCatByUser(User user);

}
