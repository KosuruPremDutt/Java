package com.wipro.service;

import java.util.List;

import com.wipro.entity.HEmployee;

public interface HEmployeeService {
	public void createEmployee(HEmployee employee);
	public List<HEmployee> getAllEmployees();
	public HEmployee getAnEmployee(String email);
	public List<HEmployee> updateEmployee(HEmployee employee);
	public List<HEmployee> deleteEmployee(Long eid);
	public HEmployee getEmpById(Long eid);
}