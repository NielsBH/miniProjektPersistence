package Controllayer;

import Modellayer.Product;

public interface ProductControllerIF {
	Product findByBarcode(String barcode);
}
