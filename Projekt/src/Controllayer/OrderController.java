package Controllayer;

import DBLayer.*;
import Modellayer.*;

public class OrderController implements OrderControllerIF {

	@Override
	public Order createOrder() {
		LoginControllerIF lc = LoginController.getInstance();
		Employee e = lc.getLoginEmp();
		if (e == null) {
			return null;
		}
		Order o = new Order(e);
		return o;
	}

	@Override
	public Orderline scanProduct(String barcode, int quantity) {
		if (quantity == 0) {
			return null;
		}
		ProductControllerIF pc = new ProductController();
		Product p = pc.findByBarcode(barcode);
		
		if (p == null) {
			return null;
		}
		
		Orderline ol = new Orderline(p, quantity);
		return ol;
	}

	@Override
	public Customer addCustomer(String email) {
		CustomerControllerIF cc = new CustomerController();
		Customer c = cc.findByEmail(email);
		return c;
	}

	@Override
	public Order payment(Order o) {
		Order res = null;
		if (o == null) {
			return null;
		}
		o = o.finishOrder(o);
		OrderDBIF odb = new OrderDB(); 
		res = odb.addOrder(o);
		return res;
	}

}
