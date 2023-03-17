package test;

import static org.junit.Assume.assumeNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Controllayer.*;
import DBLayer.*;
import Modellayer.*;

class OrderTest {
	private static final DBConnection DBCONNECTION = DBConnection.getInstance();
	private static OrderControllerIF orderCTRL;
	private static ProductControllerIF productCTRL;
	private static CustomerControllerIF customerCTRL;
	private static LoginControllerIF loginCTRL;
	private static final String BARCODE = "5555555555555";
	private static final String EMAIL = "dat@mail.com";
	private static final String EMPLOYEENAME = "Hanne";
	private static final String EMPLOYEEPHONENR = "25252525";
	private static final int EMPLOYEENR = 1;
	
	@BeforeEach
	void setup() {
		orderCTRL = new OrderController();
		productCTRL = new ProductController();
		customerCTRL = new CustomerController();
		loginCTRL = LoginController.getInstance();
		Employee emp = new Employee(EMPLOYEENAME, EMPLOYEEPHONENR, EMPLOYEENR);
		loginCTRL.login(emp);
	}
	@Test
	void createOrderTest() {
		Order o = null;
		o = orderCTRL.createOrder();
		assertTrue(o != null);
	}
	@Test
	void createAndAssociateEmployee() {
		Order o = null;
		o = orderCTRL.createOrder();
		assertEquals(o.getEmployee().getEmployeeNr(), EMPLOYEENR);
	}
	
	// Denne tester både efter et ikke eksiterende men også ikke rigtig barcode
	@Test
	void noProduktFound() {
		Order o = null;
		o = orderCTRL.createOrder();
		Orderline ol = orderCTRL.scanProduct("00000", 1);
		assertNull(ol);
	}
	
	@Test
	void testDBConnection() {
		DBConnection dbConnection = DBConnection.getInstance();
		Connection connection = dbConnection.getConnection();
		assertNotNull(connection);
	}
	
	@Test
	void empNotLoggedIn() {
		Order o = null;
		loginCTRL.logOut();
		o = orderCTRL.createOrder();
		assertNull(o);
	}
	@Test
	void cantRegisterProductWith0Quantity() {
		Order o = null;
		o = orderCTRL.createOrder();
		Orderline ol = orderCTRL.scanProduct(BARCODE, 0);
		assertNull(ol);
	}
	@Test
	void wrongEmail() {
		Order o = null;
		o = orderCTRL.createOrder();
		orderCTRL.addCustomer("Poul@mail.com");
		assertTrue(o.getCustomer() == null);
	}
	@Test
	void notAbleToPay() {
		Order o = null;
		o = orderCTRL.createOrder();
		assertNull(orderCTRL.payment(null));
	}
}
