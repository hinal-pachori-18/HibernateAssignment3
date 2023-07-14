package com.example.HibernateAssignment2.service.impl;

import com.example.HibernateAssignment2.entity.Department;
import com.example.HibernateAssignment2.entity.Professor;
import com.example.HibernateAssignment2.entity.University;
import com.example.HibernateAssignment2.repository.DepartmentRepository;
import com.example.HibernateAssignment2.repository.ProfessorRepository;
import com.example.HibernateAssignment2.repository.UniversityRepository;
import com.example.HibernateAssignment2.service.DepartmentService;
import com.example.HibernateAssignment2.service.ProfessorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorServiceImpl implements ProfessorService {
    @Autowired
    ProfessorRepository professorRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    public List<Professor> getAllProfessor() {
        return professorRepository.findAll();
    }

    @Transactional
    public Professor addProfessor(Professor professor) {
        Professor save = professorRepository.save(professor);
        final Department department = professor.getDepartment();
        if (department != null) {
            departmentRepository.save(department);
        } else {
            throw new RuntimeException("department not found");
        }
        return save;
    }

    public String deleteProfessor(int id) {
        if (professorRepository.findById(id).isPresent()) {
            professorRepository.deleteById(id);
            return "Successfully deleted";
        } else {
            return "Not Deleted";
        }
    }
}
