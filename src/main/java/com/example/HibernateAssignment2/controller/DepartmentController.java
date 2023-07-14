package com.example.HibernateAssignment2.controller;

import com.example.HibernateAssignment2.entity.Department;
import com.example.HibernateAssignment2.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartment() {
        List<Department> allDepartment = departmentService.getAllDepartment();
        return new ResponseEntity<>(allDepartment, HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
        Department department1 = departmentService.addDepartment(department);
        return new ResponseEntity<>(department1, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable String id) {
        String s = departmentService.deleteDepartment(id);
        return new ResponseEntity<>(s, HttpStatus.OK);
    }
}
