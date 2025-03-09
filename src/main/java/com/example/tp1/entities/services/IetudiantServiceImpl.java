package com.example.tp1.entities.services;

import com.example.tp1.entities.Etudiant;
import com.example.tp1.repositories.IEtudiant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class IetudiantServiceImpl implements IEtudiantService {
    IEtudiant etudiant;
    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return (List<Etudiant>)etudiant.findAll();
    }

    @Override
    public List<Etudiant> addEtudiants(List<Etudiant> etudiants) {
        return etudiant.saveAll(etudiants);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiant.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(long idEtudiant) {
        return etudiant.findById(idEtudiant).get();
    }

    @Override
    public void removeEtudiant(long idEtudiant) {
     etudiant.deleteById(idEtudiant);
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiant.save(e);
    }
}
