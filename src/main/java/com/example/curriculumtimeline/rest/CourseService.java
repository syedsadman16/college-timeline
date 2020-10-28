package com.example.curriculumtimeline.rest;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

/**  
 * Creates a singleton instance of the buisness service
 */
@Service 
public class CourseService {

    @Autowired 
    private ClassesRepository classesRepository;
    @Autowired
    MongoTemplate mongoTemplate;

    Semester container = new Semester();

    /*
     * Returns the Map stored inside the database
     */
    public  List<Semester> getTest() {
       return classesRepository.findAll();
   }

    /**
     * Takes in the semester and the list of courses passed in
     * Check the map to see if the course object under the semester
     * actually exists. If yes, then append the course object, else
     * insert it for the first time
     */
    public void addTest(String semester, List<Courses> course) {

        if(container.course_list.containsKey(semester)) {
            container.course_list.get(semester).addAll(course);
        } else {
            container.course_list.put(semester, course);
        }

        // Insert into single collection instead of creating new objects in db
        container.id = "semester";
        classesRepository.save(container);
    }

    /**
     * Semester and Id from path,Course object from json passed in
     * First get the correct list from the hashmap with the semester array
     * Iterate through the list and find the object that contains the key
     * Update the contents of the existing object using the new object and
     * finally save changed by replacing list with updated valie
    */
    public void editTest(String semester, String id, Courses courses) {

        Query query = new Query();
        query.addCriteria(Criteria.where("course_list."+semester+"._id").is(id));
        Update update = new Update();
        update.set("course_list."+semester+".$", courses);
        mongoTemplate.updateMulti(query, update, Semester.class);

    }

    /**
     * Find the correct semester array in the map
     * Use Java 8 array method to find and remove object with id
     */
    public void deleteTest(String semester, int id){

        Query query = new Query();
        query.addCriteria(Criteria.where("course_list."+semester+"._id").is(id));
        Update update = new Update();
        update.unset("course_list."+semester+".$");
        mongoTemplate.updateMulti(query, update, Semester.class);

    }

    /*
     * Query for a specific object within the Array
     */
    public List<Semester> seachQuery(String semester, String id){
        Query query = new Query();
        query.addCriteria(Criteria.where("course_list."+semester+"._id").is(id));
        return mongoTemplate.find(query, Semester.class);
    }

//    public void updateSingleValue(String semester, int id, int field){
//        Query query = new Query();
//        query.addCriteria(Criteria.where("course_list.._id").is("CS332"));
//        Update update = new Update();
//        update.set("course_list.Spring2022.$.courseNumber",456);
//        mongoTemplate.updateMulti(query, update, Semester.class);
//    }


 

}