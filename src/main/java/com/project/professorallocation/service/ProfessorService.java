package com.project.professorallocation.service;

import org.springframework.stereotype.Service;

import com.project.professorallocation.repository.ProfessorRepository;

@Service
public class ProfessorService {
	private final ProfessorRepository repository;

	public ProfessorService(ProfessorRepository repository) {
		super();
		this.repository = repository;
	}
}
