package com.wipro.controller;

import java.io.IOException;

public interface Customerinterface {
	public void addCustomer();
	public void viewCustomer();
	public void sortCustomerByIdComparable();
	public void sortCustomerByNameComparator();
	public void serializeCustomer() throws IOException;
	public void deSerializeCustomer() throws IOException;
	public void getDBMetaData();
	public void insertusingProcedure();
}