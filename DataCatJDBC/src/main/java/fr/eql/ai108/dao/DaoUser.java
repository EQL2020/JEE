package fr.eql.ai108.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

import fr.eql.ai108.jdbc.demo.CatDataSource;


public class DaoUser implements IDaoUser {
	
	private DataSource ds = new CatDataSource();
	private static final String REQ_AUTH = "SELECT * FROM user WHERE login = ? AND password = ?";
	private static final String REQ_INSERT =
			"INSERT into user (name, surname, login, password) VALUES (?, ?, ?, ?)";
	private static final String REQ_EXIST = "SELECT * FROM user WHERE login = ?";
	@Override
	public User authenticate(String login, String password) {
		Connection cnx = null;
		User user = null;
		
		try {
			cnx = ds.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(REQ_AUTH);
			pstmt.setString(1, login);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				user = new User(rs.getInt("id"), rs.getString("login"), rs.getString("password"), rs.getString("name"), rs.getString("surname"));
			}
			cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void insertUser(User user) {
		Connection cnx = null;
		try {
			cnx = ds.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(REQ_INSERT);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getSurname());
			pstmt.setString(3, user.getLogin());
			pstmt.setString(4, user.getPassword());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean isExist(User user) {
		Connection cnx = null;
		boolean exist = true;
		try {
			cnx = ds.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(REQ_EXIST);
			pstmt.setString(1, user.getLogin());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next() == false) {
				exist = false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return exist;
	}	
}
