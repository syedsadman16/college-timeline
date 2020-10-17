package com.example.curriculumtimeline.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service // Marks as buisness service 
public class CourseService {

    @Autowired
    private ClassesRepository classesRepository;
   // ArrayList<Courses> course_list = new ArrayList<>();

    public List<Courses> viewAllCourses(){
        return classesRepository.findAll();
    }

    public void addCourse(Courses course){
        classesRepository.save(course);
    }

    public void edit(Courses course, String id){
        Courses updateCourse = classesRepository.findById(id).orElseThrow();
        updateCourse = course;
        classesRepository.save(updateCourse);
        // updateCourse.setCourseNumber(course.getCourseNumber());
        // updateCourse.setCredits(course.getCredits());
        // updateCourse.setID(course.getID());
        // updateCourse.setName(name);
    }

    public void delete(Courses course, String id){
        Courses deleteCourse = classesRepository.findById(id).orElseThrow();
        classesRepository.delete(deleteCourse);
    }

}