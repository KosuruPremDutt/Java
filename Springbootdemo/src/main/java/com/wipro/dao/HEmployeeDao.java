package com.wipro.dao;

import java.util.List;

import com.wipro.entity.HEmployee;

public interface HEmployeeDao {
	public void createEmployee(HEmployee employee);
	public List<HEmployee> getAllEmployees();
	public HEmployee getAnEmployee(String email);
	public List<HEmployee> updateEmployee(HEmployee employee);
	public List<HEmployee> deleteEmployee(int eid);
}