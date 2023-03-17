package DBLayer;

import java.sql.ResultSet;

import Modellayer.Product;

public interface ProductDBIF {
	Product findByBarcode(String barcode);
	Product buildObject(ResultSet rs);
	void buildObjects(ResultSet rs);
}