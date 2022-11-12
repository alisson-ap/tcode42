package com.magalhaes.Tcoder42.controller;

import com.magalhaes.Tcoder42.model.Course;
import com.magalhaes.Tcoder42.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseController {
    private final CourseRepository courseRepository;

    @GetMapping
    public List<Course> list() {
        return courseRepository.findAll();

    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Course saveCourse(@RequestBody Course course) {
        return courseRepository.save(course );
    }

    @GetMapping(value = "/{id}")
    public Course getCourse(@PathVariable Long id){
       return courseRepository.findById(id).get();

    }

}
