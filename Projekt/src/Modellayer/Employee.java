package Modellayer;

public class Employee {
	private String name;
	private String phoneNr;
	private int employeeNr;
	
	public Employee(String name, String phoneNr, int employeeNr) {
		super();
		this.name = name;
		this.phoneNr = phoneNr;
		this.employeeNr = employeeNr;
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

	public int getEmployeeNr() {
		return employeeNr;
	}

	public void setEmployeeNr(int employeeNr) {
		this.employeeNr = employeeNr;
	}
	
}
