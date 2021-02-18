package fr.eql.ai108.jpa.heritage;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import fr.eql.ai108.jpa.entity.Cat;
import fr.eql.ai108.jpa.entity.Toy;
import fr.eql.ai108.jpa.entity.User;

public class TestHeritage {

	public static void main(String[] args) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("CatPU");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			AppUser user = new AppUser(null, "user", "user");
			em.persist(user);
			Administrator admin = new Administrator(null, "admin", "admin", 42);
			em.persist(admin);
			Customer customer = new Customer(null, "customer", "customer", 1231486);
			em.persist(customer);

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
