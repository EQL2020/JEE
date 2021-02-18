package fr.eql.ai108.jpa.program;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.eql.ai108.jpa.entity.Cat;
import fr.eql.ai108.jpa.entity.User;

public class TestCascade {

	public static void main(String[] args) {
		// EntityManagerFactory nous permet d'instancier un EntityManager (équivalent
				//de la session Hibernate) en parsant notre persistence.xml
				EntityManagerFactory emf = null;
				//EntityManager nous permet d'ouvrir une transaction et d'interagir avec notre BDD
				EntityManager em = null;
				
				try {
					emf = Persistence.createEntityManagerFactory("CatPU");
					em = emf.createEntityManager();
					em.getTransaction().begin();
					User user = new User(null, "Tutu", "de Tutu", "tutu", "tutu");
					user.setCats(new HashSet<Cat>());
					Cat felix = new Cat(null, "Félix", "Blue Russian", "felix.png",
							new Date(), user);
					Cat krys = new Cat(null, "Krys", "Bengal", "krys.jpg", new Date(), user);
					Cat garfield = new Cat(null, "Garfield", "Chat orange", "garfield.png", new Date(), user);
					user.getCats().add(felix);
					user.getCats().add(krys);
					user.getCats().add(garfield);
					em.persist(user);
					
					//Cascade remove
					User tata = em.find(User.class, 2);
					em.remove(tata);
					
					em.getTransaction().commit();
				}catch (Exception e) {
					em.getTransaction().rollback();
				}finally {
					em.close();
					emf.close();
				}


	}

}
