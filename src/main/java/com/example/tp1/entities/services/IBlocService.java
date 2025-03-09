package com.example.tp1.entities.services;

import com.example.tp1.entities.Bloc;
import jakarta.servlet.http.PushBuilder;

import java.util.List;

public interface IBlocService {
   public List<Bloc> retrieveBlocs();
   public Bloc updateBloc (Bloc bloc);
   public Bloc addBloc (Bloc bloc);
   public Bloc retrieveBloc (long idBloc);
   public void removeBloc (long idBloc);
   public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) ;

}
