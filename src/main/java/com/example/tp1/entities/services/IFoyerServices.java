package com.example.tp1.entities.services;

import com.example.tp1.entities.Foyer;
import com.example.tp1.entities.University;

import java.util.List;

public interface IFoyerServices {
    public Foyer findByid(long id);
    public List<Foyer> findAll();
    public Foyer save(Foyer foyer);
    public void delete(Foyer foyer);
    /*Foyer getNomCapacite(String name, long capacite);
     */
    public Foyer ajouterFoyerEtAffecterAUniversite (Foyer foyer, long idUniversity) ;

}
