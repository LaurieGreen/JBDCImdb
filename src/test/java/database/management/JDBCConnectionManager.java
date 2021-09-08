package database.management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import config.management.ConfigManager;

public class JDBCConnectionManager {

	private final String DATABASE_PASSWORD = ConfigManager.dbPassword();
	private final String DATABASE_USER = ConfigManager.dbUser();
	private final String DATABASE_ADDRESS = ConfigManager.dbAddress();

	private String connectionString = "jdbc:postgresql://"+DATABASE_ADDRESS+"/imdb?user="+DATABASE_USER+"&"+DATABASE_PASSWORD;

	public Connection postgresConnection() {
		Connection connection = null;

		try {
			connection = DriverManager.getConnection( connectionString );
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		return connection;
	}

	public void closeOpenConnection(Connection openConnection){
		try {
			openConnection.close();
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
	}
}
