package com.example.HibernateAssignment2.service;

import com.example.HibernateAssignment2.entity.Professor;

import java.util.List;

public interface ProfessorService {
    public List<Professor> getAllProfessor();
    public Professor addProfessor(Professor professor);
    public String deleteProfessor(int id);
}
