package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.Student;
import com.example.model.Subject;

public interface StudentService {

	public Student saveStudent(Student student);

	public Optional<Student> getStudent(Integer id);

	
}
