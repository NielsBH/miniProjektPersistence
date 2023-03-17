package DBLayer;

import java.sql.ResultSet;

import Modellayer.Product;

public interface ProductDBIF {
	Product findByBarcode(String barcode);
	Product createNewProduct(int productID, String name, double purchasePrice, double salePrice, double rentPrice, String countryOfOrigin,
			int minStock, String barcode);
	Product buildObject(ResultSet rs);
	void buildObjects(ResultSet rs);
}