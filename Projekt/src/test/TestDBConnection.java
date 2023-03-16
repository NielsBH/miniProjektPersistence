import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDBConnection {
    public static void main(String[] args) {
        // Get a DBConnection instance
        DBConnection dbConnection = DBConnection.getInstance();
        
        // Get a database connection
        Connection conn = dbConnection.getConnection();
}
    }
}

