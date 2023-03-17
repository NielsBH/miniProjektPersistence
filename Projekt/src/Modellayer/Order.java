package Modellayer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
	private LocalDate date;
	/*
	 * totalPrice fremhæver den nuværende pris på ordren.
	 * Den vil blive 0 når kunden har betalt.
	 * Det er derfor vigtigt at vide databasen kan samle den totale pris ud fra orderlines listen
	 */
	private double totalPrice;
	private boolean deliveryStatus;
	private LocalDate delieveryDate;
	private Employee emp;
	private List<Orderline> orderlines;
	private Customer customer;
	private int orderID;
	private int invoiceID;
	
	public Order(Employee emp) {
		super();
		this.emp = emp;
		totalPrice = 0;
		deliveryStatus = false;
		delieveryDate = null;
		date = LocalDate.now();
		orderlines = new ArrayList<>();
		customer = null;
	}
	
	public List<Orderline> getOrderLines() {
		return orderlines;
	}
	
	public void addOrderline(Orderline ol) {
		orderlines.add(ol);
		for(Orderline ole : orderlines) {
			double price = ole.getProduct().getSalePrice();
			double total = (price *= ole.getQuantity());
			setTotalPrice(total);
		}
	}
	
	public Employee getEmployee() {
		return emp;
	}
	
	public void setEmployee(Employee emp) {
		this.emp = emp;
	}

	public LocalDate getDate() {
		return date;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice += totalPrice;
	}

	public boolean isDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(boolean deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public LocalDate getDelieveryDate() {
		return delieveryDate;
	}

	public void setDelieveryDate(LocalDate delieveryDate) {
		this.delieveryDate = delieveryDate;
	}

	public void addCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public Order finishOrder(Order o) {
		o.setTotalPrice(0);
		return o;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getOrderID() {
		return orderID;
	}

	public int getInvoiceID() {
		return invoiceID;
	}

	public void setInvoiceID(int invoiceID) {
		this.invoiceID = invoiceID;
	}
}
