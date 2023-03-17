package Modellayer;

public class Customer {
	private String name;
	private String phoneNr;
	private int customerNr;
	private String email;
	
	public Customer(String name, String phoneNr, int customerNr, String email) {
		super();
		this.name = name;
		this.phoneNr = phoneNr;
		this.customerNr = customerNr;
		this.email = email;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNr() {
		return phoneNr;
	}

	public void setPhoneNr(String phoneNr) {
		this.phoneNr = phoneNr;
	}

	public int getCustomerNr() {
		return customerNr;
	}

	public void setCustomerNr(int customerNr) {
		this.customerNr = customerNr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
