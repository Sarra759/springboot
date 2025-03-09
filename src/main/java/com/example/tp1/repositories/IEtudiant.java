package com.example.tp1.repositories;

import com.example.tp1.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEtudiant extends JpaRepository<Etudiant, Long> {
    Etudiant findByCin(long email);
}
