package DBLayer;

import java.sql.Connection;

public class DBConnection {
	package db;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	public class DBConnection {
		private Connection connection = null;
		private static DBConnection dbConnection;
		
		private static final String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		private static final String dbName = "DMA-CSD-S222_10461241";
		private static final String serverAddress = "hildur.ucn.dk";
		//private static final String serverAddress = "192.168.56.2";
		private static final int    serverPort = 1433;
		private static final String userName = "10461241";
		private static final String password = "Password1!";
		
		private DBConnection() {
			String connectionString = String.format("jdbc:sqlserver://%s:%d;databaseName=%s;user=%s;password=%s;encrypt=false", 
					serverAddress, serverPort, dbName, userName, password);
			try {
				Class.forName(driverClass);
				connection = DriverManager.getConnection(connectionString);
			} catch (ClassNotFoundException e) {
				System.err.println("Could not load JDBC driver");
				e.printStackTrace();
			} catch (SQLException e) {
				System.err.println("Could not connect to database " + dbName + "@" + serverAddress + ":" + serverPort + " as user " + userName + " using password ******");
				System.out.println("Connection string was: " + connectionString.substring(0, connectionString.length() - password.length()) + "....");
				e.printStackTrace();
			}
		}
		
		public static DBConnection getInstance() {
			if(dbConnection == null) {
				dbConnection = new DBConnection();
			}
			return dbConnection;
		}
		
		
		public Connection getConnection() {
			return connection;
		}
		
		public void disconnect() {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
}
