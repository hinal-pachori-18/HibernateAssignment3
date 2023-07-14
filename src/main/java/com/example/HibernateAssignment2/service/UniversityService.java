package com.example.HibernateAssignment2.service;

import com.example.HibernateAssignment2.entity.University;
import com.example.HibernateAssignment2.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UniversityService {
    public List<University> getAllUniversity();
    public University addUniversity(University university);
    public String deleteUniversity(int id);




}
