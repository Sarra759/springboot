package com.example.tp1.entities.services;

import com.example.tp1.entities.Chambre;
import com.example.tp1.entities.TypeChambre;
import com.example.tp1.entities.University;
import com.example.tp1.repositories.IChambreRepository;
import com.example.tp1.repositories.IUniversityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class IchambreServiceImpl implements IChambreService {
    IChambreRepository repository;
    IUniversityRepository universityRepository;
    @Override
    public List<Chambre> retrieveAllChambres() {
        return (List<Chambre>)repository.findAll();
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return repository.save(c);
    }

    @Override
    public Chambre updateChambre(Chambre c) {
        return repository.save(c);
    }

    @Override
    public Chambre retrieveChambre(long idChambre) {
        return repository.findById(idChambre).get();
    }

    @Override
    public List<Chambre> getChambresParNomUniversite(String universityName) {
        // Vérifier si l'université existe
        University universite = universityRepository.findByUniversityName(universityName);
        // Récupérer et retourner les chambres associées à l'université via le bloc
        return repository.findByBloc_Foyer_University_UniversityName(universityName);

    }

    @Override
    public List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeChambre) {
        return repository.findByBloc_IdBlocAndTypeChambre(idBloc, typeChambre);

    }

}
