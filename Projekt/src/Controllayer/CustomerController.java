package Controllayer;

import DBLayer.CustomerDB;
import DBLayer.CustomerDBIF;
import Modellayer.Customer;

public class CustomerController implements CustomerControllerIF {

	@Override
	public Customer findByEmail(String email) {
		CustomerDBIF cdb = new CustomerDB();
		Customer c = cdb.findByEmail(email);
		return c;
	}

}