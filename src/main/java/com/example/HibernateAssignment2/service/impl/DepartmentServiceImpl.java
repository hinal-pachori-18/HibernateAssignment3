package com.example.HibernateAssignment2.service.impl;

import com.example.HibernateAssignment2.entity.Department;
import com.example.HibernateAssignment2.entity.University;
import com.example.HibernateAssignment2.repository.DepartmentRepository;
import com.example.HibernateAssignment2.repository.UniversityRepository;
import com.example.HibernateAssignment2.service.DepartmentService;
import com.example.HibernateAssignment2.service.UniversityService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    UniversityRepository universityRepository;

    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    @Transactional
    public Department addDepartment(Department department) {
        Department save = departmentRepository.save(department);
        University university = department.getUniversity();
        if (university != null) {
            universityRepository.save(university);
        } else {
            throw new RuntimeException("University not found");
        }
        return save;
    }


    public String deleteDepartment(String id) {
//
        if (departmentRepository.findById(id).isPresent()) {
            departmentRepository.deleteById(id);
            return "Successfully deleted";
        } else {
            return "Not Deleted";
        }
    }
}
