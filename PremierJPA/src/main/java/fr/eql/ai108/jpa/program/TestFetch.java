package fr.eql.ai108.jpa.program;

import java.util.Date;
import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import fr.eql.ai108.jpa.entity.Cat;
import fr.eql.ai108.jpa.entity.User;

public class TestFetch {

	public static void main(String[] args) {
		// EntityManagerFactory nous permet d'instancier un EntityManager (équivalent
		//de la session Hibernate) en parsant notre persistence.xml
		EntityManagerFactory emf = null;
		//EntityManager nous permet d'ouvrir une transaction et d'interagir avec notre BDD
		EntityManager em = null;
		User user = null;
		try {
			emf = Persistence.createEntityManagerFactory("CatPU");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			//user = em.find(User.class, 1);
			
			
			//Je veux charger en mémoire mon user avec mes chats sans utiliser le EAGER
			//Méthode 1: Faire une référence à la liste de chat alors que l'on est
			//toujours dans la trasaction
			//user.getCats().size();
			
			//Méthode 2 : Requête JPQL qui demande le chargement de la liste de chat
			String JPQL = "SELECT u FROM User u INNER JOIN FETCH u.cats WHERE u.id=1";
			Query query = em.createQuery(JPQL);
			user = (User) query.getSingleResult();
			
			em.getTransaction().commit();
		}catch (Exception e) {
			em.getTransaction().rollback();
		}finally {
			em.close();
			emf.close();
		}
		//Que reste t il en mémoire lorsque la transaction est close ?
		System.out.println(user.getName());
		System.out.println(user.getCats().size());
		for (Cat cat : user.getCats()) {
			System.out.println(cat.getName());
		}
	}

}
