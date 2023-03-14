package Controllayer;

import Modellayer.Employee;

public class LoginController implements LoginControllerIF {
	private static LoginController instance;
	private Employee emp;
	
	public LoginController getInstance() {
		if (instance != null) {
			instance = new LoginController();
		}
		return instance;
	}
	
	private LoginController() {
		this.emp = null;
	}

	@Override
	public void login(String pincode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void isLoggedIn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee getLoginEmp() {
		// TODO Auto-generated method stub
		return null;
	}

}
