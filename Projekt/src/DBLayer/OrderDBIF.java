package DBLayer;

import java.sql.ResultSet;

import Modellayer.Employee;
import Modellayer.Order;

public interface OrderDBIF {
	Order addOrder(Order o); 
	Order buildObject(ResultSet rs);
	void buildObjects(ResultSet rs);
}
