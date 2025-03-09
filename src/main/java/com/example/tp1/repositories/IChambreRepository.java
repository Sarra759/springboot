package com.example.tp1.repositories;

import com.example.tp1.entities.Bloc;
import com.example.tp1.entities.Chambre;
import com.example.tp1.entities.Reservation;
import com.example.tp1.entities.TypeChambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface IChambreRepository extends JpaRepository<Chambre, Long> {
 List<Chambre> findByNumchambreIn(List<Long> numchambres);
 Optional<Chambre> findFirstByBlocAndCapaciteRestanteGreaterThan(Bloc bloc, int capaciteRestante);
 Chambre findByReservationsContains(Reservation reservation);
 List<Chambre> findByBloc_Foyer_University_UniversityName(String universityName);
 List<Chambre> findByBloc_IdBlocAndTypeChambre(long idBloc, TypeChambre typeChambre );
}
