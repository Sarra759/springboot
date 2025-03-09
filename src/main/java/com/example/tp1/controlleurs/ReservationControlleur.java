package com.example.tp1.controlleurs;

import com.example.tp1.entities.Reservation;
import com.example.tp1.entities.services.IReservationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@RequestMapping("/reservation")
@RestController
public class ReservationControlleur {
    IReservationService reservationService;
@GetMapping("/retrieveReservation/{id}")
public Reservation retrieveReservation(@PathVariable long id) {
    return reservationService.retrieveReservation(id);
}
@PutMapping("/update")
    public Reservation updateReservation(@RequestBody Reservation reservation) {
    return reservationService.updateReservation(reservation);
}
@GetMapping("/retrieveAllReservation")
    public List<Reservation> retrieveAllReservation() {
    return reservationService.retrieveAllReservation();
}
    @PostMapping("/ajouter/{idBloc}/{cinEtudiant}")
    public Reservation ajouterReservation( @PathVariable long idBloc, @PathVariable long cinEtudiant) {

        return reservationService.ajouterReservation(idBloc, cinEtudiant);

    }
    @DeleteMapping("/annuler/{cinEtudiant}")
    public Reservation annulerReservation (@PathVariable long cinEtudiant) {
        return reservationService.annulerReservation(cinEtudiant);
    }



    }
