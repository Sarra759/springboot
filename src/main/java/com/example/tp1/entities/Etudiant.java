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
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Etudiant {
    @Id
    @GeneratedValue
    private long idEtudiant;
    private String nom;
    private String prenom;
    private long cin;
    private String ecole;
    private Date dateNaissance;
    @ManyToMany
    private Set<Reservation> reservations;
}
