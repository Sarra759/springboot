package com.example.tp1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue
    private long idReservation;
    @Temporal(TemporalType.DATE)
    private Date dateReservation;
    private boolean estvalide;
@ManyToMany(mappedBy="reservations")
    private Set<Etudiant> etudiants;
@ManyToOne
    private Chambre chambre;
    private String numReservation;

    public void setNumReservation(String numReservation) {
        this.numReservation = numReservation;
    }
}
