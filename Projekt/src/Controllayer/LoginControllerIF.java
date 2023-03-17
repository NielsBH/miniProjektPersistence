package Controllayer;

import Modellayer.Employee;

public interface LoginControllerIF {
	void login(Employee emp);
	void isLoggedIn();
	Employee getLoginEmp();
	void logOut();
}