package Modellayer;

public class Product {
	private String name;
	private double purchasePrice;
	private double salePrice;
	private double rentPrice;
	private String countryOfOrigin;
	private int minStock;
	private String barcode;
	private int productID;
	public Product(int productID, String name, double purchasePrice, double salePrice, double rentPrice, String countryOfOrigin,
			int minStock, String barcode) {
		super();
		this.productID = productID;
		this.name = name;
		this.purchasePrice = purchasePrice;
		this.salePrice = salePrice;
		this.rentPrice = rentPrice;
		this.countryOfOrigin = countryOfOrigin;
		this.minStock = minStock;
		this.barcode = barcode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	public double getRentPrice() {
		return rentPrice;
	}
	public void setRentPrice(double rentPrice) {
		this.rentPrice = rentPrice;
	}
	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}
	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}
	public int getMinStock() {
		return minStock;
	}
	public void setMinStock(int minStock) {
		this.minStock = minStock;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public int getProductID() {
		return productID;
	}
	public void setID(int id) {
		this.productID = id;
	}
	
}
