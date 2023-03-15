package DBLayer;

import java.sql.ResultSet;

import Modellayer.Product;

public interface ProductDBIF {
	void findByBarcode(String barcode);
	Product buildObject(ResultSet rs);
	void buildObjects(ResultSet rs);
}