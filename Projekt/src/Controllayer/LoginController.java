package Controllayer;

import Modellayer.Employee;

public class LoginController implements LoginControllerIF {
	private static LoginController instance;
	private Employee emp;
	
	public static LoginController getInstance() {
		if (instance == null) {
			instance = new LoginController();
		}
		return instance;
	}
	
	private LoginController() {
		this.emp = null;
	}

	@Override
	public void login(Employee emp) {
		this.emp = emp;
	}
	
	@Override
	public void isLoggedIn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee getLoginEmp() {
		return emp;
	}

	@Override
	public void logOut() {
		login(null);
	}

}
