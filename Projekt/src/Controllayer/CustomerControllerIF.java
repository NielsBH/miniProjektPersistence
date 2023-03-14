package Controllayer;

import Modellayer.Customer;

public interface CustomerControllerIF {
	Customer findByEmail(String email);
}