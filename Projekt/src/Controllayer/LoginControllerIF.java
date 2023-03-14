package Controllayer;

import Modellayer.Employee;

public interface LoginControllerIF {
	void login(String pincode);
	void isLoggedIn();
	Employee getLoginEmp();
}