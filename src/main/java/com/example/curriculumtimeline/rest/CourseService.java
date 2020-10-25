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


//    List<Semester> semesterList = new ArrayList<>();
//
//    public void addTest(Semester sem){
//        Semester course = new Semester();
//
//        semesterList.add(sem);
//    }
//
//    public List<Semester> getTest() {
//        return semesterList;
//    }


    /**  
    * Hold an ArrayList of Map objects in the instance
    * String determines the Semester within the JSON and List<Courses> allows
    * it to hold multiple Course objects under a single Semster
    */
    //ArrayList<Map<String, List<Courses>>> course_list = new ArrayList<>();



    HashMap<String, List<Courses>> course_list = new HashMap<String, List<Courses>>();


//    public void addTest(Map<String, List<Courses>> courses) {
//        course_list.put(courses);
//    }

    public Map<String, List<Courses>> getTest() {
        return course_list;
    }


    public void addTest(String semester, List<Courses> course) {

            if(course_list.containsKey(semester)) {
                course_list.get(semester).addAll(course);
            } else {
                course_list.put(semester, course);
            }

    }

    /**
    * Get the correct semester array where course is located
    * Use the ID to find the course and save new course object
    */
    public void editTest(String semester, String id, Courses courses) {
        System.out.println("SEMESTER " + semester + " ID "+ id+ "\n");
        System.out.println("COURSE " + courses);
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
       // int index = updatedCourse.indexOf(id);
        // Update the object
//        updatedCourse.get(index).replaceAll(courses.getSubject(),
//                                 courses.getCourseNumber(), courses.getName(),
//                                 courses.getCredits(), courses.getSemester());
        // // Find the index containing this Id
        // int size = updatedCourse.size();
        // int index = IntStream.range(0, size)
        // .filter(i -> updatedCourse.get(i).getID().equals(id))
        // .findFirst().orElse(-1);
        // updatedCourse.set(index, courses);
        // Save changes to entire list
       // course_list.replace(semester, updatedCourse);
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