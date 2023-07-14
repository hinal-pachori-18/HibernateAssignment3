package com.example.HibernateAssignment2.controller;

import com.example.HibernateAssignment2.entity.University;
import com.example.HibernateAssignment2.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/university")
public class UniversityController {

    @Autowired
    UniversityService universityService;

    @GetMapping
    public ResponseEntity<List<University>> getAllUniversity() {
        List<University> allUniversity = universityService.getAllUniversity();
        return new ResponseEntity<>(allUniversity, HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<University> addUniversity(@RequestBody University university) {
        University university1 = universityService.addUniversity(university);
        return new ResponseEntity<>(university1, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUniversity(@PathVariable int id) {
        String s = universityService.deleteUniversity(id);
        return new ResponseEntity<>(s, HttpStatus.OK);
    }


}
