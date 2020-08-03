package com.example.curriculumtimeline.rest;

import java.util.ArrayList;

import org.springframework.stereotype.Service;


@Service // Marks as buisness service 
public class CourseService {
    ArrayList<Courses> course_list = new ArrayList<>();

    public ArrayList<Courses> viewAllCourses(){
        return course_list;
    }

    public void addCourse(Courses course){
        course_list.add(course);
    }

    public void edit(Courses course, String id){
        for(int i=0; i<course_list.size(); i++){
            if(course_list.get(i).getID().equals(id)){
                course_list.set(i, course);
                return;
            }
        }
    }

    public void delete(Courses course, String id){
        course_list.removeIf(x -> x.getID().equals(id));
    }

}