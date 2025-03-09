package com.example.tp1.entities.services;

import com.example.tp1.entities.*;
import com.example.tp1.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.time.Year;
import java.time.ZoneId;
import java.util.*;

@Service
@AllArgsConstructor
public class IreservationServiceImpl implements IReservationService {

    IReservationRepository reservationRepository;
    IBlocRepository blocRepository;
    IEtudiant etudiantRepository;
    IChambreRepository chambreRepository;
    IUniversityRepository universityRepository;

    @Override
    public List<Reservation> retrieveAllReservation() {
        return (List<Reservation>) reservationRepository.findAll();
    }

    @Override
    public Reservation updateReservation(Reservation res) {
        return reservationRepository.save(res);
    }

    @Override
    public Reservation retrieveReservation(long idReservation) {
        return reservationRepository.findById(idReservation).get();
    }

    @Override
    public Reservation ajouterReservation(long idBloc, long cinEtudiant) {
        // Vérifier si le bloc existe
        Bloc bloc = blocRepository.findById(idBloc)
                .orElseThrow(() -> new RuntimeException("Bloc non trouvé avec l'ID : " + idBloc));

        // Vérifier si l'étudiant existe
        Etudiant etudiant = etudiantRepository.findByCin(cinEtudiant);
        if (etudiant == null) {
            throw new RuntimeException("Étudiant non trouvé avec le CIN : " + cinEtudiant);
        }

        // Trouver une chambre disponible dans le bloc
        Chambre chambre = chambreRepository.findFirstByBlocAndCapaciteRestanteGreaterThan(bloc, 0)
                .orElseThrow(() -> new RuntimeException("Aucune chambre disponible dans ce bloc !"));

        // Vérifier la capacité maximale de la chambre
        if (chambre.getReservations().size() >= getCapaciteMaximale(chambre.getTypeChambre())) {
            throw new RuntimeException("La capacité maximale de la chambre est atteinte !");
        }

        // Générer le numéro de réservation
        int anneeUniversitaire = Year.now().getValue();
        String numReservation = chambre.getNumchambre() + "-" + bloc.getNom() + "-" + anneeUniversitaire;

        // Créer et sauvegarder la réservation
        Reservation reservation = new Reservation();
        reservation.setDateReservation(new Date());
        reservation.setEstvalide(true);
        reservation.setNumReservation(numReservation);
        reservation.setEtudiants(Collections.singleton(etudiant));
        reservation.setChambre(chambre);
        reservation = reservationRepository.save(reservation);

        // Ajouter la réservation à la liste des réservations de l'étudiant
        etudiant.getReservations().add(reservation);
        etudiantRepository.save(etudiant); // Sauvegarder l'étudiant avec la réservation

        return reservation;
    }

    @Override
    public Reservation annulerReservation(long cinEtudiant) {
        // Vérifier si l'étudiant existe
        Etudiant etudiant = etudiantRepository.findByCin(cinEtudiant);
        if (etudiant == null) {
            throw new RuntimeException("Étudiant non trouvé avec le CIN : " + cinEtudiant);
        }

        // Trouver la réservation active de cet étudiant
        Reservation reservation = reservationRepository.findFirstByEtudiantsContainsAndEstvalideTrue(etudiant);
        if (reservation == null) {
            throw new RuntimeException("Aucune réservation active trouvée pour cet étudiant !");
        }

        // Désactiver la réservation
        reservation.setEstvalide(false);

        // Désaffecter l'étudiant de la réservation
        if (reservation.getEtudiants() != null && reservation.getEtudiants().contains(etudiant)) {
            reservation.getEtudiants().remove(etudiant);
        } else {
            throw new RuntimeException("L'étudiant n'est pas associé à cette réservation !");
        }

        // Trouver la chambre associée
        Chambre chambre = chambreRepository.findByReservationsContains(reservation);
        if (chambre != null) {
            // Libérer la place dans la chambre
            chambre.setCapaciteRestante(chambre.getCapaciteRestante() + 1);

            // Supprimer la réservation de la liste des réservations de la chambre
            chambre.getReservations().remove(reservation);

            // Sauvegarder la chambre mise à jour
            chambreRepository.save(chambre);
        }

        // Supprimer la réservation de la liste des réservations de l'étudiant
        etudiant.getReservations().remove(reservation);
        etudiantRepository.save(etudiant);

        // Supprimer complètement la réservation si aucun étudiant n'est associé
        if (reservation.getEtudiants().isEmpty()) {
            reservationRepository.delete(reservation);
        } else {
            reservationRepository.save(reservation);
        }

        return reservation;
    }




    private int getCapaciteMaximale(TypeChambre typeChambre) {
        switch (typeChambre) {
            case simple:
                return 1;
            case Double:
                return 2;
            case Triple:
                return 3;
            default:
                throw new RuntimeException("Type de chambre inconnu");
        }
    }





}



