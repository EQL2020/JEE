package fr.eql.ai108.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import fr.eql.ai108.jdbc.demo.CatDataSource;

public class DaoCat implements IDaoCat{

	private DataSource ds = new CatDataSource();
	private static final String REQ_GET = "SELECT * FROM cat";
	private static final String REQ_ADD = "INSERT INTO cat (name, race, birth) VALUES (?,?,?)";
	private static final String REQ_FIND = "SELECT * FROM cat WHERE name like ?";
	private static final String REQ_GET_BY_USER = "SELECT * FROM cat WHERE id_user = ?";

	@Override
	public void addCat(Cat cat) {
		Connection cnx = null;

		try {
			cnx = ds.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(REQ_ADD);
			pstmt.setString(1, cat.getName());
			pstmt.setString(2, cat.getRace());
			pstmt.setDate(3, Date.valueOf(cat.getBirth()));
			pstmt.executeUpdate();
			cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Cat> findByName(String name) {
		Connection cnx = null;
		List<Cat> cats = new ArrayList<Cat>();
		try {
			cnx = ds.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(REQ_FIND);
			StringBuilder sb = new StringBuilder();
			sb.append("%").append(name).append("%");
			pstmt.setString(1, sb.toString());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Cat cat = new Cat(rs.getInt("id"), rs.getString("name"), rs.getString("race"), rs.getDate("birth").toLocalDate());
				cats.add(cat);
			}
			cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cats;
	}

	@Override
	public List<Cat> getAll() {
		Connection cnx = null;
		List<Cat> cats = new ArrayList<Cat>();
		try {
			cnx = ds.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(REQ_GET);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Cat cat = new Cat(rs.getInt("id"), rs.getString("name"), rs.getString("race"), rs.getDate("birth").toLocalDate());
				cats.add(cat);
			}
			cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cats;
	}

	@Override
	public List<Cat> getCatByUser(User user) {
		List<Cat> cats = new ArrayList<Cat>();
		Connection cnx = null;

		try {
			cnx = ds.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(REQ_GET_BY_USER);
			pstmt.setInt(1, user.getId());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				cats.add(new Cat(rs.getInt("id"), rs.getString("name"), rs.getString("race"), rs.getDate("birth").toLocalDate(), rs.getString("photo")));
			}
			cnx.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cats;
	}
}