package com.example.tp1.entities.services;

import com.example.tp1.entities.Reservation;

import java.util.Date;
import java.util.List;

public interface IReservationService {
     public   List<Reservation> retrieveAllReservation();
      public          Reservation updateReservation (Reservation res);
      public      Reservation retrieveReservation (long idReservation);
    public Reservation ajouterReservation (long idBloc, long cinEtudiant) ;
    public Reservation annulerReservation (long cinEtudiant) ;
}
