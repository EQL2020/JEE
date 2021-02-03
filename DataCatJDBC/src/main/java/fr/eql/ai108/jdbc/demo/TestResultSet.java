package fr.eql.ai108.jdbc.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javax.sql.DataSource;

public class TestResultSet {

	public static void main(String[] args) {
		DataSource ds = new CatDataSource();
		Connection cnx = null;
		
		try {
			cnx = ds.getConnection();
			String req = "SELECT id, name, race, birth FROM cat";
			Statement stmt = cnx.createStatement();
			
			//On récupère dans un objet ResultSet le résultat de l'exécution de notre query
			ResultSet rs = stmt.executeQuery(req);
			
			//On itère sur le ResultSet tant qu'il reste des lignes de résultat
			while(rs.next()) {
				//Pour chaque ligne dans le resultset, on récupère nos champs
				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				String race = rs.getString("race");
				LocalDate birth = rs.getDate("birth").toLocalDate();
				
				StringBuilder sb = new StringBuilder();
				sb.append("id: ").append(id.toString()).append("\tname: ").append(name)
				.append("\trace: ").append(race).append("\tbirth: ").append(birth);
				System.out.println(sb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
