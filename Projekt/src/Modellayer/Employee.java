package Modellayer;

public class Employee {
	private String name;
	private String phoneNr;
	private String employeeNr;
	
	public Employee(String name, String phoneNr, String employeeNr) {
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

	public String getEmployeeNr() {
		return employeeNr;
	}

	public void setEmployeeNr(String employeeNr) {
		this.employeeNr = employeeNr;
	}
	
}
