package Controllayer;

import Modellayer.*;

public interface OrderControllerIF {
	Order createOrder();
	Orderline scanProduct(String barcode, int quantity);
	Customer addCustomer(String email);
	Order payment(Order o);
}