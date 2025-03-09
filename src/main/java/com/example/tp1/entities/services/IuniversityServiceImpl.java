package com.example.tp1.entities.services;

import com.example.tp1.entities.Foyer;
import com.example.tp1.entities.University;
import com.example.tp1.repositories.IFoyerRepository;
import com.example.tp1.repositories.IUniversityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class IuniversityServiceImpl  implements IUniversityService {
    IUniversityRepository universityRepository;
    IFoyerRepository foyerRepository;

    @Override
    public List<University> retrieveAllUniversities() {
        return (List<University>) universityRepository.findAll();
    }

    @Override
    public University addUniversite(University university) {
        return universityRepository.save(university);
    }

    @Override
    public University updateUniversite(University u) {
        return universityRepository.save(u);
    }

    @Override
    public University retrieveUniversite(long idUniversity) {
        return universityRepository.findById(idUniversity).get();
    }

    @Override
    public University affecterFoyerAUniversite(long idFoyer, String universityName) {
        // Vérifier si l'université existe
        University university = universityRepository.findByUniversityName(universityName);
        Foyer foyer = foyerRepository.findById(idFoyer).get();
        university.setFoyer(foyer);
        universityRepository.save(university);
        return university;

    }

    @Override
    public University desaffecterFoyerAUniversite(long idUniversity) {
        University university = universityRepository.findById(idUniversity).get();
        Foyer foyer = foyerRepository.findById(idUniversity).get();
        university.setFoyer(null);
        universityRepository.save(university);
        return university;

    }
}
