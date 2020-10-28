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


    @RequestMapping("/getCourses")
    public List<Semester> getCourses() {
        return service.getCourses();
    }

    /**
     * Use a pathvariable to specify which semester array to insert the object into
     */
    @RequestMapping(method=RequestMethod.POST, value="/addCourses/{semester}")
    public List<Courses> addCourse(@PathVariable String semester, @RequestBody Courses courseObj) {
        List<Courses> course = new ArrayList<>();
        course.add(courseObj);
        service.addCourses(semester, course);
        return course;
    }

    /**
     * Index by semester array into object
     */
    @RequestMapping(method=RequestMethod.POST, value="/editCourses/{semester}/{id}")
    public Courses editCourses(@PathVariable String semester, @PathVariable String id, @RequestBody Courses course) {
        service.editCourses(semester, id, course);
        return course;
    }

    /*
     * Delete entire object within a semester usign the id
     */
    @RequestMapping(method=RequestMethod.DELETE, value="/deleteCourses/{semester}/{id}")
    public void deleteCourses(@PathVariable String semester, @PathVariable String id){
        service.deleteCourses(semester, id);
    }

    /*
     * Search for specific object within the array and return it
     */
    @RequestMapping(method=RequestMethod.GET, value="/search")
    public List<Semester> search(@PathVariable String semester, @PathVariable String id){
        return service.seachQuery(semester, id);
    }

//    @RequestMapping(method=RequestMethod.POST, value="/setQ")
//    public void setQuery(){
//         service.setQuery();
//    }


}