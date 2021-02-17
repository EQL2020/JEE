package fr.eql.ai108.hibernate.program;

import org.hibernate.Session;

import fr.eql.ai108.hibernate.util.HibernateUtil;

public class TestHibernate {

	public static void main(String[] args) {
		// La session hibernate va nous permettre de nous connecter à notre BDD
		Session session = HibernateUtil.getSession();
		System.out.println("Session hibernate OK");
		session.close();

	}

}
