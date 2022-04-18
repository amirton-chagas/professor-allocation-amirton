package com.project.professorallocation.service;

import org.springframework.stereotype.Service;

import com.project.professorallocation.repository.AllocationRepository;

@Service
public class AllocationService {
	private final AllocationRepository repository;

	public AllocationService(AllocationRepository repository) {
		super();
		this.repository = repository;
	}
}
