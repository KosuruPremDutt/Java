package com.wipro;
//POJO -- Plain Old Java Object

import com.wipro.model.Address;

public class Customer{
	
	int y=200;
	static int z=300;
	
	public int display() {
		System.out.println("Displaying.....");
		return 10;
	}
	
	public static void main(String[] args){
		int x=100; //local
        System.out.println("X =" + x);
        
        System.out.println("z =" +z);
        Customer customer = new Customer();  // class instatiation
        System.out.println("y = " +customer.y);
        
        int s = customer.display();   // only when the variable value is used 
        System.out.println(s);
        
        System.out.println(customer.display());
    }

	public void setCname(String cname) {
		// TODO Auto-generated method stub
		
	}

	public void setCid(int cid) {
		// TODO Auto-generated method stub
		
	}

	public void setAddress(Address addr) {
		// TODO Auto-generated method stub
		
	}

	public String getCid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCname() {
		// TODO Auto-generated method stub
		return null;
	}
}

