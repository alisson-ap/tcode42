package com.magalhaes.Tcoder42.repository;

import com.magalhaes.Tcoder42.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {


}
