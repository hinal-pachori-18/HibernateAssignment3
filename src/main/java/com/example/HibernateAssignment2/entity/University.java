package com.example.HibernateAssignment2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class University {
    @Id
    private int id;
    private String name;
    private String address;
    @OneToMany(mappedBy = "university", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Department> departments;
}
