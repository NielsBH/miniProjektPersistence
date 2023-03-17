package DBLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Modellayer.Customer;
import Modellayer.Product;

public class ProductDB implements ProductDBIF{

	@Override
	public Product findByBarcode(String barcode) {
		Product p = null;
		DBConnection dbConnection = DBConnection.getInstance();

        try {
        	Connection connection = dbConnection.getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM product WHERE barcode = '" + barcode + "'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
            	int pID = resultSet.getInt("productID");
                String name = resultSet.getString("pName");
                double pPrice = resultSet.getDouble("purchasePrice");
                double sPrice = resultSet.getDouble("salesPrice");
                double rPrice = resultSet.getDouble("rentPrice");
                String countryOR = resultSet.getString("contryOfOrigin");
                int minStock = resultSet.getInt("stock");
                
                p = new Product(pID, name, pPrice, sPrice, rPrice, countryOR, minStock, barcode);
            }
        } catch (SQLException e) {
        	e.printStackTrace();
        }
        return p;
	}

	@Override
	public Product buildObject(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void buildObjects(ResultSet rs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product createNewProduct(int productID, String name, double purchasePrice, double salePrice,
			double rentPrice, String countryOfOrigin, int minStock, String barcode) {
		// TODO Auto-generated method stub
		return null;
	}

}
