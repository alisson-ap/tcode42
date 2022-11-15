package com.magalhaes.Tcoder42.controller;

import com.magalhaes.Tcoder42.model.Course;
import com.magalhaes.Tcoder42.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Course> getCourse(@PathVariable Long id){
       return courseRepository.findById(id).map(record -> ResponseEntity.ok().body(record)).orElse(ResponseEntity.notFound().build());

    }
    @PutMapping(value = "/{id}")
    public void editById(@RequestBody Course course, @PathVariable Long id){
        Course obj = courseRepository.findById(id).get();
        obj.setName(course.getName());
        obj.setCategory(course.getCategory());
        courseRepository.saveAndFlush(obj);
    }

}
