package com.example.curriculumtimeline.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**  
 * Creates a singleton instance of the buisness service
 */
@Service 
public class CourseService {

    @Autowired 
    private ClassesRepository classesRepository;

    HashMap<String, List<Courses>> course_list = new HashMap<String, List<Courses>>();


    public Map<String, List<Courses>> getTest() {
        return course_list;
    }

    /**
     * Takes in the semester and the list of courses passed in
     * Check the map to see if the course object under the semester
     * actually exists. If yes, then append the course object, else
     * insert it for the first time
     */
    public void addTest(String semester, List<Courses> course) {

            if(course_list.containsKey(semester)) {
                course_list.get(semester).addAll(course);
            } else {
                course_list.put(semester, course);
            }

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
       List<Courses> updatedCourse = course_list.get(semester);

        // Find object within list
        for(int i=0; i<updatedCourse.size(); i++){
            if (updatedCourse.get(i).getID().equals(id)){
                updatedCourse.get(i).replaceAll(courses.getSubject(),
                                courses.getCourseNumber(), courses.getName(),
                                courses.getCredits(), courses.getSemester());
                course_list.replace(semester, updatedCourse);
            }
        }
    }

    /**
     * Find the correct semester array in the map
     * Use Java 8 array method to find and remove object with id
     */
    public void deleteTest(String semester, String id){
        course_list.get(semester).removeIf(p->p.getID().equals(id));
    }



    /**  
    * Older methods for previous rest design
    */

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
    }

    public void delete(Courses course, String id){
        Courses deleteCourse = classesRepository.findById(id).orElseThrow();
        classesRepository.delete(deleteCourse);
    }

}