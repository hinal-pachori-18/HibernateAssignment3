package com.example.HibernateAssignment2.service.impl;

import com.example.HibernateAssignment2.entity.University;
import com.example.HibernateAssignment2.repository.UniversityRepository;
import com.example.HibernateAssignment2.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class UniversityServiceImpl implements UniversityService {
    @Autowired
    UniversityRepository universityRepository;

    public List<University> getAllUniversity() {
        return universityRepository.findAll();
    }

    public University addUniversity(University university) {
        return universityRepository.save(university);
    }

    public String deleteUniversity(int id) {
        if (universityRepository.findById(id).isPresent()) {
            universityRepository.deleteById(id);
            return "Successfully deleted";
        } else {
            return "Not deleted";
        }
    }
}
