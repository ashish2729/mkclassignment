package com.example.serviceImpl;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.model.Student;
import com.example.repository.StudentRepository;
import com.example.service.StudentService;

public class StudentImpl implements StudentService {

	@Autowired
	private StudentRepository repo;

	@Override
	public Student saveStudent(Student student) {
		return repo.save(student);
	}

	@Override
	public Optional<Student> getStudent(Integer id) {
		return repo.findById(id);

	}
}
