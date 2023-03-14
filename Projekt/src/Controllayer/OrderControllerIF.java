package Controllayer;

public interface OrderControllerIF {
	void createOrder();
	void scanProduct(String barcode, int quantity);
	void addCustomer(String email);
	void addDelivery(String address);
	void payment();
}
