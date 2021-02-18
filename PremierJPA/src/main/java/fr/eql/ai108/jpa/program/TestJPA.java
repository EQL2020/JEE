package fr.eql.ai108.jpa.program;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestJPA {

	public static void main(String[] args) {
		// EntityManagerFactory nous permet d'instancier un EntityManager (équivalent
		//de la session Hibernate) en parsant notre persistence.xml
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CatPU");
		System.out.println("Configuration OK");
	}

}
