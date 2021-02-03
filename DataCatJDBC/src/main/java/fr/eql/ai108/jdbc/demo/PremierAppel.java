package fr.eql.ai108.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PremierAppel {

	public static void main(String[] args) {
		
		//Utilisateur de notre bdd
		String username = "root";
		
		//Password de notre bdd
		String password = "root";
		
		//URL de notre bdd avec quelques paramètres
		String url = "jdbc:mysql://127.0.0.1:3306/cat_db?"
				+ "serverTimezone=Europe/Paris&verifyServerCertificate=false"
				+ "&useSSL=false";
		
		String driver = "com.mysql.cj.jdbc.Driver";
		Connection cnx = null;
		try {
			//Charger en mémoire le driver
			Class.forName(driver);
			//Connexion à la bdd
			cnx = DriverManager.getConnection(url, username, password);
			System.out.println("Connexion OK");
			
			String req = "INSERT INTO cat (name, race, birth) VALUES ('Muta', 'Ragdoll', '2017-09-02')";
			
			//L'objet statement encapsule notre requête SQL
			Statement stmt = cnx.createStatement();
			
			//On execute notre statement en lui transmettant la requête
			int success = stmt.executeUpdate(req);
			
			System.out.println(success == 1 ? "Insert ok" : "Bah ça marche pas!");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				cnx.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
