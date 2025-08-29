package com.wipro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.entity.HEmployee;
import com.wipro.service.HEmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class HEmployeeRestController {
	
	@Autowired
	private HEmployeeService hEmployeeService;
	
	@GetMapping("/hi")
	public String hiAll() {
		return "Hi ";
	}
	
	@GetMapping("/allempl")
	public ResponseEntity<List<HEmployee>>  listAllEmployees() {
		List<HEmployee> emplist = hEmployeeService.getAllEmployees();
		if(emplist.isEmpty()) {
			return new ResponseEntity<List<HEmployee>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<HEmployee>>(emplist,HttpStatus.OK);
	}
	
	@PostMapping("/createEmp")
	public HEmployee  createEmployees(@RequestBody HEmployee employee) {
		hEmployeeService.createEmployee(employee);		
		return employee;
	}
	
	@GetMapping("/getAnEmp/{em}")
	public ResponseEntity<HEmployee> getAnEmployee(@PathVariable("em") String email) {
		HEmployee emp = hEmployeeService.getAnEmployee(email);
		if(emp == null) {
			return new ResponseEntity<HEmployee>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<HEmployee>(emp,HttpStatus.OK);
	}
	@PutMapping("/updateempl")
	public ResponseEntity<List<HEmployee>>  updateEmployees(@RequestBody HEmployee employee) {
		List<HEmployee> emplist = hEmployeeService.updateEmployee(employee);
		if(emplist.isEmpty()) {
			return new ResponseEntity<List<HEmployee>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<HEmployee>>(emplist,HttpStatus.OK);
	}
	@DeleteMapping("/deleteempl/{id}")
	public ResponseEntity<List<HEmployee>>  deleteEmployees(@PathVariable("id") Long eid ) {
		List<HEmployee> emplist = hEmployeeService.deleteEmployee(eid);
		if(emplist.isEmpty()) {
			return new ResponseEntity<List<HEmployee>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<HEmployee>>(emplist,HttpStatus.OK);
	}
	
	@GetMapping("/getEmpById/{eid}")
	public ResponseEntity<HEmployee> getEmployeeById(@PathVariable("eid") Long eid) {
		HEmployee emp = hEmployeeService.getEmpById(eid);
		if(emp == null) {
			return new ResponseEntity<HEmployee>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<HEmployee>(emp,HttpStatus.OK);
	}
}