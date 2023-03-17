package DBLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Modellayer.Customer;

public class CustomerDB implements CustomerDBIF{

	@Override
	public Customer findByEmail(String email) {
		Customer c = null;
		DBConnection dbConnection = DBConnection.getInstance();

        try {
        	Connection connection = dbConnection.getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM customer WHERE email = '" + email + "'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
            	int customerNr = resultSet.getInt("custNr");
                String name = resultSet.getString("cName");
                String phone = resultSet.getString("phoneNr");
                
                c = new Customer(name, phone, customerNr, email);
            }
        } catch (SQLException e) {
        	e.printStackTrace();
        }
        return c;
	}

	@Override
	public Customer buildObject(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void buildObjects(ResultSet rs) {
		// TODO Auto-generated method stub
		
	}

}
