package fr.eql.ai108.jpa.dao;

import java.util.Date;

import fr.eql.ai108.jpa.entity.Cat;
import fr.eql.ai108.jpa.entity.User;

public class TestGenericDao {

	public static void main(String[] args) {
		UserIDao userDao = new UserDao();
		User user = new User(null, "Dao", "Dao", "Dao", "Dao");
		userDao.add(user);
		userDao.delete(user);
		
		CatIDao catDao = new CatDao();
		Cat cat = new Cat(null, "Cat", "Cat", "Cat", new Date());
		catDao.add(cat);
		cat.setName("TotoCat");
		catDao.update(cat);
		Cat klong = catDao.findById(1);
		System.out.println(klong.getName());
		

	}

}
