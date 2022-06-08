package com.example.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.model.Subject;
import com.example.repository.SubjectRepository;
import com.example.service.SubjectService;

public class SubjectImpl implements SubjectService {

	@Autowired
	private SubjectRepository repo;

	@Override
	public List<Subject> saveSubject(Subject subject) {
		return (List<Subject>) repo.save(subject);
	}

}
