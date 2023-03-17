package DBLayer;

import java.sql.ResultSet;

import Modellayer.Customer;

public interface CustomerDBIF {
	Customer findByEmail(String email);
	Customer createNewCustomer(String name, String phoneNr, int customerNr, String email);
	Customer buildObject(ResultSet rs);
	void buildObjects(ResultSet rs);
}
