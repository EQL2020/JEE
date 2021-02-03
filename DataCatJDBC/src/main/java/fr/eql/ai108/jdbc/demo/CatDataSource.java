package fr.eql.ai108.jdbc.demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

public class CatDataSource implements DataSource{
	
	private static String username;
	private static String password;
	private static String url;
	
	//A l'initialisation de la DataSource, on lit les données dans le fichier properties
	
	static {
		Properties props = new Properties();
		InputStream is = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("fr/eql/ai108/jdbc/demo/cat_db.properties");
		try {
			props.load(is);
			url = props.getProperty("jndiPath");
			username = props.getProperty("username");
			password = props.getProperty("password");
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		return DriverManager.getConnection(url, username, password);
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
