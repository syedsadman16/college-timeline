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
@RestController
public class CourseController {

    @Autowired // Spring marks it as an injection of dependencies
    private CourseService service; // Creates an instance of the service
    
    @RequestMapping("/")
    public List<Courses> getCourses(){
        return service.viewAllCourses();
    } 

    @RequestMapping(method=RequestMethod.POST, value="/add")
    public void addCourse(@RequestBody Courses course){
        service.addCourse(course);
    }

    @RequestMapping("/test")
    public ArrayList<Map<String, List<Courses>>> getGreeting() {
        return service.getTest();
    } 

    @RequestMapping(method=RequestMethod.POST, value="/addTest")
    public Map<String, List<Courses>> addCourse(@RequestBody Map<String, List<Courses>> course) {
      //  HashMap<String, List<Courses>> finalMap = new HashMap<>();
       // finalMap.put(course.get(0).getSemester(), course.get(course));
        service.addTest(course);
        return course;
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