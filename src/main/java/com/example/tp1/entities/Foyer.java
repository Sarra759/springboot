package com.example.tp1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Foyer {
    @Id
    @GeneratedValue
    private long idFoyer;
    private String name;
    private long capacityfoyer;
@OneToOne(mappedBy = "foyer")
   private University university;
@OneToMany(mappedBy="foyer",cascade = CascadeType.ALL)
private Set<Bloc> blocs = new HashSet<>();

}
