package Modellayer;

import java.time.LocalDate;

public class Order {
	private LocalDate date;
	private double totalPrice;
	private boolean deliveryStatus;
	private LocalDate delieveryDate;
	
	public Order(LocalDate date, double totalPrice, boolean deliveryStatus, LocalDate delieveryDate) {
		super();
		this.date = date;
		this.totalPrice = totalPrice;
		this.deliveryStatus = deliveryStatus;
		this.delieveryDate = delieveryDate;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
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
	
}
