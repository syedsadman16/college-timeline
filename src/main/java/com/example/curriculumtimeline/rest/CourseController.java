package com.example.curriculumtimeline.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
@RestController
public class CourseController {

    /*
    * Marked as an injection of dependencies for the classpath
    */
    @Autowired
    private CourseService service;


    @RequestMapping("/test")
    public Map<String, List<Courses>> getGreeting() {
        return service.getTest();
    }

    /**
     * Use a pathvariable to specify which semester array to insert the object into
     */
    @RequestMapping(method=RequestMethod.POST, value="/addTest/{semester}")
    public List<Courses> addCourse(@PathVariable String semester, @RequestBody Courses courseObj) {
        List<Courses> course = new ArrayList<>();
        course.add(courseObj);
        service.addTest(semester, course);
        return course;
    }

    /**
     * Index by semester array into object
     */
    @RequestMapping(method=RequestMethod.PUT, value="/editTest/{semester}/{id}")
    public Courses editTest(@PathVariable("semester") String semester, @PathVariable("id") String id, @RequestBody Courses course) {
        service.editTest(semester, id, course);
        return course;
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/delete/{semester}/{id}")
    public void deleteTest(@PathVariable String semester, @PathVariable String id){
        service.deleteTest(semester, id);
    }


    /**
     * Mongodb tied controllers
     */
    @RequestMapping(method=RequestMethod.POST, value="/add")
    public void addCourse(@RequestBody Courses course){
        service.addCourse(course);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/edit/{id}")
    public void editCourse(@RequestBody Courses course, @PathVariable String id){
        service.edit(course, id);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/delete/{id}")
    public void deleteCourse(@RequestBody Courses course, @PathVariable String id){
        service.delete(course, id);
    }
}