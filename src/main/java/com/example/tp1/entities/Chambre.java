package com.example.tp1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Chambre {

    @Id
    @GeneratedValue
    private long idchambre;

    private long numchambre;

    @Enumerated(EnumType.STRING)
    private TypeChambre typeChambre;

    @ManyToOne
    private Bloc bloc;

    @OneToMany(mappedBy = "chambre")
    private Set<Reservation> reservations;

    // Capacite restante de la chambre
    private int capaciteRestante;




}
