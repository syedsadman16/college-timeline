package com.example.curriculumtimeline.rest;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Document
public class Semester {

    @Id
    String id;
    String test;
    Map<String, List<Courses>> course_list = new HashMap<String, List<Courses>>();;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public Semester() { }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, List<Courses>> getCourse_list() {
        return course_list;
    }

    public void setCourse_list(Map<String, List<Courses>> course_list) {
        this.course_list = course_list;
    }
}
