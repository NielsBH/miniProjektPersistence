package DBLayer;

import java.sql.ResultSet;

import Modellayer.Employee;
import Modellayer.Order;

public interface OrderDBIF {
	void newOrder(Employee emp); 
	Order buildObject(ResultSet rs);
	void buildObjects(ResultSet rs);
}
