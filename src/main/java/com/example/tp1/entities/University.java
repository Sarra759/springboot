package com.example.tp1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class University {
    @Id
    @GeneratedValue
    private long idUniversity;
    private String universityName;
    private String universityAddress;
    @OneToOne
    private Foyer foyer;


}
