package com.project.professorallocation.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.professorallocation.model.Course;
import com.project.professorallocation.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {
	private final CourseService service;

	public CourseController(CourseService service) {
		super();
		this.service = service;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Course>> findAll() {
		List<Course> allItems = service.findAll(null);

		return new ResponseEntity<>(allItems, HttpStatus.OK);
	}

	@GetMapping(path = "/{item_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Course> findById(@PathVariable(name = "item_id") Long id) {
		Course item = service.findById(id);

		if (item == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(item, HttpStatus.OK);
		}
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Course> create(@RequestBody Course item) {
		Course newItem = service.create(item);

		return new ResponseEntity<>(newItem, HttpStatus.CREATED);
	}

	@PutMapping(path = "/{item_id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Course> update(@PathVariable(name = "item_id") Long id, @RequestBody Course item) {
		item.setId(id);
		Course updatedItem = service.update(item);

		if (updatedItem == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(item, HttpStatus.OK);
		}
	}

	@DeleteMapping(path = "/{item_id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> delete(@PathVariable(name = "item_id") Long id) {
		service.deleteById(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
