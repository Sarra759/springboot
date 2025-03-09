package com.example.tp1.entities.services;

import com.example.tp1.entities.Etudiant;

import java.util.List;

public interface IEtudiantService {
    public   List<Etudiant> retrieveAllEtudiants();
   public List<Etudiant> addEtudiants (List<Etudiant> etudiants);
   public  Etudiant updateEtudiant (Etudiant e);
    public Etudiant retrieveEtudiant(long idEtudiant);
    public void removeEtudiant(long idEtudiant);
    public Etudiant addEtudiant(Etudiant e);

}
