package test;

import java.sql.Connection;
import DBLayer.DBConnection;

public class TestDBConnection {
    public static void main(String[] args) {
        // Get a DBConnection instance
        DBConnection dbConnection = DBConnection.getInstance();
        
        // Get a database connection
        Connection con = dbConnection.getConnection();
        if (con != null) {
        	System.out.println("success");
        }
    }
}