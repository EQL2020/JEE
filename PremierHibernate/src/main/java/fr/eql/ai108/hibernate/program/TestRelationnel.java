package fr.eql.ai108.hibernate.program;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.eql.ai108.hibernate.entity.Cat;
import fr.eql.ai108.hibernate.entity.User;
import fr.eql.ai108.hibernate.util.HibernateUtil;

public class TestRelationnel {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		User toto = (User) session.get(User.class, 1);
		Cat noisette = new Cat(null, "Noisette", 
				"Norvégien", "noisette.jpg", new Date(), toto);
		Cat cachou = new Cat(null, "Cachou", "Européen", "cachou.jpg", new Date(), toto);
		Cat eliot = new Cat(null, "Eliot", "Savannah", "eliot.jpg", new Date(), toto);
		
		//session.save(noisette);
		//session.save(cachou);
		//session.save(eliot);
		toto.getCats().add(noisette);
		toto.getCats().add(cachou);
		toto.getCats().add(eliot);
		
		tx.commit();
		session.close();

	}

}
