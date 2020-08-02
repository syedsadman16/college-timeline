package com.example.curriculumtimeline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Annotation that tells the type of application
@SpringBootApplication
public class CollegeCurriculumTimelineApplication {

	public static void main(String[] args) {
		// Create a servlet container and host the application in it
		SpringApplication.run(CollegeCurriculumTimelineApplication.class, args);
	}

}
