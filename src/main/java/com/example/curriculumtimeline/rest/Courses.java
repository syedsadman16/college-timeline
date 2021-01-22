package com.example.curriculumtimeline.rest;

import javax.annotation.Generated;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Courses {

    /*
    * These fields are defined in the rest RequestBody
    * When writing JSON, delcare these vaiables or it will be left null
    * The ID is annotated with the Id tag
    */
    @Id
    private String ID;
    private String subject;
    private int courseNumber;
    private String name;
    private int credits;
    private String semester;
    private String color;
    private String description;


    public Courses() { }

    public Courses(String id, String sub, int num, String name, int cr, String sem, String color, String description){
        super();
        this.subject = sub;
        this.ID = id;
        this.courseNumber = num;
        this.name = name;
        this.credits = cr;
        this.semester = sem;
        this.color = color;
        this.description = description;
    }

    public void replaceAll(String sub, int num, String named, int cr, String sem){
       subject = sub;
       courseNumber = num;
        name = named;
        credits = cr;
        semester = sem;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

     
}
