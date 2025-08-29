package com.wipro.demosprmysql.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.demosprmysql.entity.Student;
import com.wipro.demosprmysql.exception.StudentNotFoundException;
import com.wipro.demosprmysql.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentRestController {
	@Autowired
	private StudentService studentService;

	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}

	@GetMapping("/getAll")
	public List<Student> getAllStudents() {

		return studentService.getAllStudents();
	}
	
	@GetMapping("/{id}")
	public Optional<Student> getAStudent(@PathVariable Long id) {
		Optional<Student> st = studentService.getAStudent(id);
		if(st.isPresent()) {
			return st;
		}else {
			throw new StudentNotFoundException("OOPS !!! No Such Student with id " + id);
		}
		 
	}

}