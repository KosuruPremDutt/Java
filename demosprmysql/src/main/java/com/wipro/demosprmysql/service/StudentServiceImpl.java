package com.wipro.demosprmysql.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.demosprmysql.entity.Student;
import com.wipro.demosprmysql.repository.StudentRepository;
@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Student createStudent(Student student) {
		return studentRepository.save(student);
		
	}

	@Override
	public List<Student> getAllStudents() {
		
		return studentRepository.findAll();
	}

	@Override
	public Optional<Student> getAStudent(Long id) {
		
		return studentRepository.findById(id);
	}

}