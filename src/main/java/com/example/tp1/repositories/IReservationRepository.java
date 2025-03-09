package com.example.tp1.repositories;

import com.example.tp1.entities.Etudiant;
import com.example.tp1.entities.Reservation;
import com.example.tp1.entities.University;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface IReservationRepository extends JpaRepository<Reservation, Long> {
    Reservation findFirstByEtudiantsContainsAndEstvalideTrue(Etudiant etudiant);

}
