package com.example.tp1.repositories;

import com.example.tp1.entities.Foyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFoyerRepository extends JpaRepository<Foyer, Long> {
    Long idFoyer(long idFoyer);
    /* public Foyer findByNomAndCapaciteFoyer(String name, long capaciteFoyer);

    */
}
