package DBLayer;

import java.sql.Connection;

public class DBConnection {
	private static DBConnection instance;
	
	public DBConnection getInstance() {
		if (instance == null) {
			instance = new DBConnection();
		}
		return instance;
	}
	
	private DBConnection() {
		// Implement connection to database
	}
	
	public Connection disconnect() {
		return null;
	}
}
