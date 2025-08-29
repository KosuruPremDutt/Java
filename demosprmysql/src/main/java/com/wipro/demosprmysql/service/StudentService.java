package com.wipro.demosprmysql.service;

import java.util.List;
import java.util.Optional;

import com.wipro.demosprmysql.entity.Student;

public interface StudentService {
	public Student createStudent(Student student);
	public List<Student> getAllStudents();
	public Optional<Student> getAStudent(Long id);
}