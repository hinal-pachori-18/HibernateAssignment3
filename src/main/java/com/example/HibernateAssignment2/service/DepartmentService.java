package com.example.HibernateAssignment2.service;

import com.example.HibernateAssignment2.entity.Department;

import java.util.List;

public interface DepartmentService {
    public List<Department> getAllDepartment();
    public Department addDepartment(Department department);
    public String deleteDepartment(String id);

}
