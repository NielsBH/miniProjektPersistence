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

}