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
    //HashMap<String, List<Courses>> course_list = new HashMap<String, List<Courses>>();
    //MongoOperations mongoOps = new MongoTemplate(new SimpleMongoClientDbFactory(MongoClients.create(), "<dbname>"));


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
        container.test = "remove_me";
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

        // Get entire course list under the semester - this should be saved
       List<Courses> updatedCourse = container.course_list.get(semester);

        // Find object within list
        for(int i=0; i<updatedCourse.size(); i++){
            if (updatedCourse.get(i).getID().equals(id)){
                updatedCourse.get(i).replaceAll(courses.getSubject(),
                                courses.getCourseNumber(), courses.getName(),
                                courses.getCredits(), courses.getSemester());
                container.course_list.replace(semester, updatedCourse);
            }
        }
    }

    /**
     * Find the correct semester array in the map
     * Use Java 8 array method to find and remove object with id
     */
    public void deleteTest(String semester, int id){
        //container.course_list.get(semester).removeIf(p->p.getID().equals(id));
//        String object = "course_list."+semester+".id";
////
//       MongoOperations mongoTemplate = new MongoTemplate(MongoClients.create(), "database");
//
        Query query = new Query();
        query.addCriteria(Criteria.where("course_list.Spring2022._id").is("CS332"));
        //query.fields().include("course_list.Spring2022.$");
        Update update = new Update();
        update.unset("course_list.Spring2022.$");

// run update operation
        mongoTemplate.updateMulti(query, update, Semester.class);
        System.out.println("UPDATE OBJ: " + query.toString());


       // Query removeQuery = Query.query(Criteria.where("innerDocs.name").in(ids));



//        mongoTemplate.updateMulti(new Query(),
//                new Update().pull("course_list.Spring2021", Query.query(Criteria.where("courseNumber").is(30600))), "semester");
//
//        List<String> ids = Arrays.asList("innerDoc22", "innerDoc21");
//        Query removeQuery = Query.query(Criteria.where("innerDocs.name").in(ids));
//
//        WriteResult wc =
//                mongoTemplate.upsert(removeQuery,
//                        new Update().pull("innerDocs",
//                                new InnerDocument("innerDoc22", null)),
//                        OutterObject.class);
//
//        System.out.println(wc.getLastError());


//        Query query = new Query();
//
//        query.addCriteria(Criteria.where("id").is("semester"));
//
//
//        Update update = new Update();
//        update.unset("course_list.Spring2021.$.id");
//
//        mongoTemplate.updateMulti(query, update, Semester.class);
        

// run update operation


//        Update updateObj = new Update()
//                .pull("course_list.Spring2021", new BasicDBObject("courseNumber", 30600));

        //System.out.println("UPDATE OBJ: " + updateObj.toString());

    }

    public List<Semester> seachQuery(){
        Query query = new Query();
        query.addCriteria(Criteria.where("course_list.Spring2022._id").is("CS332"));
       // query.fields().include("course_list.Spring2022.$");
        return mongoTemplate.find(query, Semester.class);
    }

    public void setQuery(){
        Query query = new Query();
        query.addCriteria(Criteria.where("course_list.Spring2022._id").is("CS332"));
        Update update = new Update();
        update.set("course_list.Spring2022.$.courseNumber",456);

// run update operation
        mongoTemplate.updateMulti(query, update, Semester.class);

    }


    /**  
    * Older methods for previous rest design
    */
//
//    public List<Courses> viewAllCourses(){
//        return classesRepository.findAll();
//    }
//
//    public void addCourse(Courses course){
//        classesRepository.save(course);
//    }
//
//    public void edit(Courses course, String id){
//        Courses updateCourse = classesRepository.findById(id).orElseThrow();
//        updateCourse = course;
//        classesRepository.save(updateCourse);
//    }
//
//    public void delete(Courses course, String id){
//        Courses deleteCourse = classesRepository.findById(id).orElseThrow();
//        classesRepository.delete(deleteCourse);
//    }

}