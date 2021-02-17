package fr.eql.ai108.hibernate.program;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.eql.ai108.hibernate.entity.User;
import fr.eql.ai108.hibernate.util.HibernateUtil;

public class TestCRUD {

	public static void main(String[] args) {
		//On ouvre une connexion avec notre BDD
		Session session = HibernateUtil.getSession();
		
		//Pour interagir avec notre BDD, on ouvre une transaction
		Transaction tx = session.beginTransaction();
		
		//Insérer un User en BDD
		User user = new User(null, "hib", "ernate", "hib", "ernate");
		session.save(user);
		System.out.println("Utilisateur n° " + user.getId() + " bien inséré !");
		
		//Récupérer un User à partir de son Id
		User user2 = (User) session.get(User.class, 1);
		System.out.println("Coucou " + user2.getName() + " " + user2.getSurname());
		
		//Update un user
		user2.setName("Toto");
		
		//Suppresion d'un utilisateur
		session.delete(user2);
		
		tx.commit();
		session.close();
		
		System.exit(0);
	}

}
