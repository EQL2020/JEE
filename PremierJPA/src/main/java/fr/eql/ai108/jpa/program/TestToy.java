package fr.eql.ai108.jpa.program;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import fr.eql.ai108.jpa.entity.Cat;
import fr.eql.ai108.jpa.entity.Toy;
import fr.eql.ai108.jpa.entity.User;

public class TestToy {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("CatPU");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			
			// En SQL
			String SQL = "SELECT t.libelle FROM toy t INNER JOIN cat c ON c.id = t.cat_id INNER JOIN user u ON u.id = c.user_id WHERE u.id = 1";
			Query querySQL = em.createNativeQuery(SQL);
			List<String> nomToy = querySQL.getResultList();
			for (String string : nomToy) {
				System.out.println("nom des jouet du user1 : " + string);
			}
			
			//Avec le CRUD JPA
			User user = em.find(User.class, 1);
			for(Cat cat : user.getCats()) {
				for(Toy toy : cat.getToys()) {
					System.out.println("L'utilisateur " + user.getName() + " " + user.getSurname() + " possede le chat " + cat.getName() + " qui a le jouet " + toy.getLibelle() + " " + toy.getCouleur()+".");
				}
			}

			//En JPQL sans jointure
			String JPQL1 = "SELECT t FROM Toy t WHERE t.cat.user.id = 1";
			Query queryJPQL1 = em.createQuery(JPQL1);
			List<Toy> toys = queryJPQL1.getResultList();

			for (Toy toy : toys) {
				System.out.println("L'utilisateur " + toy.getCat().getUser().getName() + " " + toy.getCat().getUser().getSurname() + " possede le chat " + toy.getCat().getName() + " qui a le jouet " + toy.getLibelle() + " " + toy.getCouleur()+".");
			}


			// En JPQL avec jointure
			String JPQL2 = "SELECT c.toys FROM Cat c INNER JOIN c.user u WHERE u.id = 1";
			Query queryJPQL2 = em.createQuery(JPQL2);
			List<Toy> toys2 = queryJPQL2.getResultList();

			for (Toy toy : toys2) {
				System.out.println("L'utilisateur " + toy.getCat().getUser().getName() + " " + toy.getCat().getUser().getSurname() + " possede le chat " + toy.getCat().getName() + " qui a le jouet " + toy.getLibelle() + " " + toy.getCouleur()+".");
			}
			em.getTransaction().commit();
		}catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			em.close();
			emf.close();
		}
	}
}
