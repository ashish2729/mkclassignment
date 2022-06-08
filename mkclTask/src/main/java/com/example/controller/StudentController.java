package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Student;
import com.example.model.Subject;
import com.example.service.StudentService;
import com.example.service.SubjectService;

@RestController
@RequestMapping("/employee")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private SubjectService subjectService;

	// emp with address- employee with multiple address

	@PostMapping("/saveEmpAdd")
	ResponseEntity<Student> saveEmployeeAddress(@RequestBody Student employee) {
		Student employees = studentService.saveStudent(employee);
		List<Subject> add =subjectService.saveSubject(null);
		for (Subject address : add) {
			subjectService.saveSubject(address);
		}
		return ResponseEntity.ok().body(employee);

	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Optional<Student>> getEmployeeById(@PathVariable("id") Integer id) {
		Optional<Student> student = studentService.getStudent(id);

		return ResponseEntity.ok().body(student);
	}

}
