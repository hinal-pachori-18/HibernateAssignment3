package com.example.HibernateAssignment2.controller;

import com.example.HibernateAssignment2.entity.Professor;
import com.example.HibernateAssignment2.entity.University;
import com.example.HibernateAssignment2.service.ProfessorService;
import com.example.HibernateAssignment2.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/professor")
public class ProfessorController {
    @Autowired
    ProfessorService professorService;

    @GetMapping
    public ResponseEntity<List<Professor>> getAllProfessor() {
        List<Professor> allProfessor = professorService.getAllProfessor();
        return new ResponseEntity<>(allProfessor, HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<Professor> addProfessor(@RequestBody Professor professor) {
        Professor professor1 = professorService.addProfessor(professor);
        return new ResponseEntity<>(professor1, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProfessor(@PathVariable int id) {
        String s = professorService.deleteProfessor(id);
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

}
