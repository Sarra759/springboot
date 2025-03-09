package com.example.tp1.repositories;

import com.example.tp1.entities.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IUniversityRepository extends JpaRepository<University, Long> {
 University findByUniversityName(String universityName);
}
