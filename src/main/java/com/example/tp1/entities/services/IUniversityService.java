package com.example.tp1.entities.services;

import com.example.tp1.entities.University;

import java.util.List;

public interface IUniversityService {
    public List<University> retrieveAllUniversities();
    public University addUniversite (University university);
    public University updateUniversite (University u);
    public University retrieveUniversite (long idUniversity);
    public University affecterFoyerAUniversite (long idFoyer, String universityName) ;
    public University desaffecterFoyerAUniversite (long idUniversity) ;

}
