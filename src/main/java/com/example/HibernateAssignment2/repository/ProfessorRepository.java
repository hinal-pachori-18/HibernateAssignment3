package com.example.HibernateAssignment2.repository;

import com.example.HibernateAssignment2.entity.Department;
import com.example.HibernateAssignment2.entity.Professor;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor,Integer> {

    @Query("DELETE from Professor where profId=?1")
    @Modifying
    @Transactional
    public int deleteById(int id);
}
