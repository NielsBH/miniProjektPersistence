package Controllayer;

import DBLayer.*;
import Modellayer.*;

public class OrderController implements OrderControllerIF {

	@Override
	public Order createOrder() {
		LoginControllerIF lc = LoginController.getInstance();
		Employee e = lc.getLoginEmp();
		Order o = new Order(e);
		return o;
	}

	@Override
	public Orderline scanProduct(String barcode, int quantity) {
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
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Order payment(Order o) {
		Order res = null;
		o = o.finishOrder(o);
		OrderDBIF odb = new OrderDB(); 
		res = odb.addOrder(o);
		return res;
	}

}
