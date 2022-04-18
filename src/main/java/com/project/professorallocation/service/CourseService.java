package com.project.professorallocation.service;

import org.springframework.stereotype.Service;

import com.project.professorallocation.repository.CourseRepository;

@Service
public class CourseService {
	private final CourseRepository repository;

	public CourseService(CourseRepository repository) {
		super();
		this.repository = repository;
	}
}
