package fr.eql.ai108.dao;

import java.time.LocalDate;
import java.util.List;

public class Pgm {

	public static void main(String[] args) {
		IDaoCat dao = new DaoCat();
		Cat cat = new Cat(null, "Duchesse", "Chat blanc", LocalDate.now());
		dao.addCat(cat);
		List<Cat> cats = dao.getAll();
		for (Cat cat2 : cats) {
			//System.out.println(cat2.toString());
		}
		List<Cat> foundCats = dao.findByName("Duchesse");
		for (Cat cat2 : foundCats) {
			System.out.println(cat2.toString());
		}

	}

}
