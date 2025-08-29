package com.wipro.model;

import java.io.Serializable;

// POJO -- Plain Old Java Object
public class Customermodel implements Serializable{
	private int cid;
	private String cname;
	private Address address;   //Has-A address

	public Customermodel() {
		System.out.println("Customer Constr...");
	}

	public Customermodel(int cid, String cname, Address address) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.address = address;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", address=" + address + "]";
	}

}