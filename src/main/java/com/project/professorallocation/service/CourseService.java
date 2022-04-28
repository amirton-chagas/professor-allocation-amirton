package com.project.professorallocation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.professorallocation.model.Course;
import com.project.professorallocation.repository.CourseRepository;

@Service
public class CourseService {
	private final CourseRepository repository;

	public CourseService(CourseRepository repository) {
		super();
		this.repository = repository;
	}
	
	public List<Course> findAll(String name) {
        return repository.findAll();
    }

    public Course findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Course create(Course course) {
        course.setId(null);
        return saveInternal(course);
    }

    public Course update(Course course) {
        Long id = course.getId();
        if (id != null && repository.existsById(id)) {
            return saveInternal(course);
        } else {
            return null;
        }
    }

    public void deleteById(Long id) {
        if (id != null && repository.existsById(id)) {
            repository.deleteById(id);
        }
    }

    public void deleteAll() {
        repository.deleteAllInBatch();
    }

    private Course saveInternal(Course course) {
        course = repository.save(course);

        return course;
    }
}
