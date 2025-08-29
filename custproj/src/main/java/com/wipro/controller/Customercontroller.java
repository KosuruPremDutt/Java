package com.wipro.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.wipro.dao.CustomerDao;
import com.wipro.model.Address;
import com.wipro.model.Customermodel;

public class Customercontroller implements Customerinterface{
	List<Customermodel> custList = new ArrayList<>();
	Customermodel customer ; // Class instatiation
	Address addr = new Address();
	CustomerDao dao = new CustomerDao();
	
	Scanner sc = new Scanner(System.in);

	public void addCustomer() {
		customer =  new Customermodel();
		System.out.println("Enter CID");
		int cid = sc.nextInt();
		customer.setCid(cid);
		System.out.println("Enter Cname");
		String cname = sc.next();
		customer.setCname(cname);
		//customer = new Customer(cid,cname);
		System.out.println("Enter your Address");
		System.out.println("Enter Door No:");
		int doorNo = sc.nextInt();
		addr.setDoorNo(doorNo);
		
		System.out.println("Enter Street");
		String street = sc.next();
		addr.setStreet(street);
		
		System.out.println("Enter City");
		String city = sc.next();
		addr.setCity(city);
		
		System.out.println("Enter Zip");
		int zip = sc.nextInt();
		addr.setZip(zip);
		
		customer.setAddress(addr);
		
		custList.add(customer);
		dao.createCustomer(customer);
		System.out.println("Customer Added Successfully !!!");
	}

	public void viewCustomer() {
		//System.out.println("CID = " + customer.getCid() + " " + "CNAME = " + customer.getCname());
		//System.out.println(customer);
		
//		Iterator i = custList.iterator();
//		while(i.hasNext()) {
//			System.out.println(i.next());
//		}
		dao.viewCustomer();
	}

	@Override
	public void sortCustomerByIdComparable() {
		
		
	}

	@Override
	public void sortCustomerByNameComparator() {
		
		
	}

	@Override
	public void serializeCustomer() throws IOException{
		try {
			FileOutputStream fos = new FileOutputStream("myfile.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(custList);
			System.out.println("Serialized ....");
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			
			System.out.println("No file found");
		}
		
	}

	@Override
	public void deSerializeCustomer() throws IOException {
		try {
			FileInputStream fis = new FileInputStream("myfile.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			List<Customermodel> lcust = (List<Customermodel>)ois.readObject();
			System.out.println("Deserialized..");
			Iterator<Customermodel> i = lcust.iterator();
			while(i.hasNext()) {
				System.out.println(i.next());
			}
			ois.close();
			fis.close();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
		@Override
		public void getDBMetaData() {
			dao.getDBMetaData();
		}
		

@Override
public void insertusingProcedure() {
	customer =  new Customermodel();
	addr = new Address();
	System.out.println("Enter CID");
	int cid = sc.nextInt();
	customer.setCid(cid);
	System.out.println("Enter Cname");
	String cname = sc.next();
	customer.setCname(cname);
	System.out.println("Enter your Address");
	System.out.println("Enter Door No:");
	int doorNo = sc.nextInt();
	addr.setDoorNo(doorNo);
	
	System.out.println("Enter Street");
	String street = sc.next();
	addr.setStreet(street);
	
	System.out.println("Enter City");
	String city = sc.next();
	addr.setCity(city);
	
	System.out.println("Enter Zip");
	int zip = sc.nextInt();
	addr.setZip(zip);
	
	customer.setAddress(addr);		
	
	dao.insertCustUsingPro(customer);
	System.out.println("Done with insert via Procedure....");
}

}

