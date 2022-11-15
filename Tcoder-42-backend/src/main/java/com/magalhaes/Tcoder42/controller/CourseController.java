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

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable Long id){
       return courseRepository.findById(id).map(recordFound -> ResponseEntity.ok().body(recordFound)).orElse(ResponseEntity.notFound().build());

    }
    @PutMapping("/{id}")
    public ResponseEntity <Course> update(@PathVariable Long id, @RequestBody Course course){
       return courseRepository.findById(id).map(recordFound -> {
                    recordFound.setName(course.getName());
                    recordFound.setCategory(course.getCategory());
                    Course update = courseRepository.save(recordFound);
                    return ResponseEntity.ok().body(update);
               }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        return courseRepository.findById(id).map(recordFound -> {
               courseRepository.deleteById(id);
               return ResponseEntity.noContent().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }

}
