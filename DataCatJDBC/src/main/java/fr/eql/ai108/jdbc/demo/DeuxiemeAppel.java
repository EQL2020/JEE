package fr.eql.ai108.jdbc.demo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class DeuxiemeAppel {

	public static void main(String[] args) {
		Connection cnx = null;
		
		//Pour se connecter, on instancie notre CatDataSource:
		DataSource ds = new CatDataSource();
		try {
			cnx = ds.getConnection();
			System.out.println("Connexion OK");
			String req = "INSERT INTO cat (name, race, birth) "
					+ "VALUES ('Flipette', 'Norvégien', '2010-01-01')";
			Statement stmt = cnx.createStatement();
			int success = stmt.executeUpdate(req);
			System.out.println(success == 1 ? "Insert ok" : "Ça marche pô !!!");
		} catch (SQLException e) {
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
