package Controllayer;

import DBLayer.ProductDB;
import DBLayer.ProductDBIF;
import Modellayer.Product;

public class ProductController implements ProductControllerIF{

	@Override
	public Product findByBarcode(String barcode) {
		ProductDBIF pdb = new ProductDB();
		Product p = pdb.findByBarcode(barcode);
		return p;
	}

	@Override
	public Product newProduct(int productID, String name, double purchasePrice, double salePrice, double rentPrice,
			String countryOfOrigin, int minStock, String barcode) {
		ProductDBIF pdb = new ProductDB();
		Product p = pdb.createNewProduct(productID, name, purchasePrice, salePrice, rentPrice, countryOfOrigin, minStock, barcode);
		return p;
	}

}