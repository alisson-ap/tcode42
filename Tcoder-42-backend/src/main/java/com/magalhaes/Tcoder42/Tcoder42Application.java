package com.magalhaes.Tcoder42;

import com.magalhaes.Tcoder42.model.Course;
import com.magalhaes.Tcoder42.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Tcoder42Application {

	public static void main(String[] args) {
		SpringApplication.run(Tcoder42Application.class, args);
	}
	@Bean
	CommandLineRunner initDatabase(CourseRepository courseRepository){
		return args -> {
			courseRepository.deleteAll();

			Course c = new Course();
			c.setName("Angular e spring");
			c.setCategory("front-end");

			courseRepository.save(c);
		};

	}
}
