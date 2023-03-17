package Controllayer;

import Modellayer.Product;

public interface ProductControllerIF {
	Product findByBarcode(String barcode);
	Product newProduct(int productID, String name, double purchasePrice, double salePrice, double rentPrice, String countryOfOrigin,
			int minStock, String barcode);
}
