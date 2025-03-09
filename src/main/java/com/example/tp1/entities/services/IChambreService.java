package com.example.tp1.entities.services;

import com.example.tp1.entities.Chambre;
import com.example.tp1.entities.TypeChambre;

import java.util.List;

public interface IChambreService {
    public List<Chambre> retrieveAllChambres();
    public  Chambre addChambre(Chambre c);
    public  Chambre updateChambre (Chambre c);
    public   Chambre retrieveChambre (long idChambre);
    public List<Chambre> getChambresParNomUniversite( String universityName) ;
    public List<Chambre> getChambresParBlocEtType (long idBloc, TypeChambre typeChambre) ;

}
