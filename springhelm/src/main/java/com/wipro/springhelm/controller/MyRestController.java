package com.wipro.springhelm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cust")
public class MyRestController {
	@GetMapping("/hello")
	public String myMethod() {
		return "Hello !!!. Welcome to Helm";
	}

}