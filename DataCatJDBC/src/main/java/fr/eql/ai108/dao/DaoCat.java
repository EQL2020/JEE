package fr.eql.ai108.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import fr.eql.ai108.jdbc.demo.CatDataSource;

public class DaoCat implements IDaoCat {
	
	private DataSource ds = new CatDataSource();
	private Connection cnx;
	private static final String  REQ_ADD = "INSERT INTO cat (name, race, birth) "
			+ "VALUES (?, ?, ?)";
	private static final String REQ_GET_ALL = "SELECT * from cat";
	private static final String REQ_FIND = "SELECT * FROM cat WHERE name like ?";

	@Override
	public void addCat(Cat cat) {
		cnx = null;
		try {
			cnx = ds.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(REQ_ADD);
			pstmt.setString(1, cat.getName());
			pstmt.setString(2, cat.getRace());
			pstmt.setDate(3, Date.valueOf(cat.getBirth()));
			pstmt.executeUpdate();
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

	@Override
	public List<Cat> getAll() {
		cnx = null;
		List<Cat> cats = new ArrayList<Cat>();
		try {
			cnx = ds.getConnection();
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(REQ_GET_ALL);
			while (rs.next()) {
				Cat cat = new Cat(rs.getInt("id"), rs.getString("name"),
						rs.getString("race"), rs.getDate("birth").toLocalDate());
				cats.add(cat);
			}
			
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
		return cats;
	}

	@Override
	public List<Cat> findByName(String name) {
		cnx = null;
		List<Cat> cats = new ArrayList<Cat>();
		try {
			cnx = ds.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(REQ_FIND);
			pstmt.setString(1, "%" + name + "%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Cat cat = new Cat(rs.getInt("id"), rs.getString("name"),
						rs.getString("race"), rs.getDate("birth").toLocalDate());
				cats.add(cat);
			}
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
		return cats;
	}

}
