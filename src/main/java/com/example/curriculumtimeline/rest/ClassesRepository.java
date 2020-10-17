package com.example.curriculumtimeline.rest;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassesRepository extends MongoRepository<Courses, String> {

}
    

