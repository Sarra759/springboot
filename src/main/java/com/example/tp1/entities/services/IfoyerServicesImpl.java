package com.example.tp1.entities.services;

import com.example.tp1.entities.Bloc;
import com.example.tp1.entities.Chambre;
import com.example.tp1.entities.Foyer;
import com.example.tp1.entities.University;
import com.example.tp1.repositories.IBlocRepository;
import com.example.tp1.repositories.IChambreRepository;
import com.example.tp1.repositories.IFoyerRepository;
import com.example.tp1.repositories.IUniversityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class IfoyerServicesImpl implements IFoyerServices {
    IFoyerRepository foyerRepository;
    IUniversityRepository universityRepository;
    IBlocRepository blocRepository;

    @Override
    public Foyer findByid(long id) {
        return foyerRepository.findById(id).get();
    }

    @Override
    public List<Foyer> findAll() {
        return (List<Foyer>) foyerRepository.findAll();
    }

    @Override
    public Foyer save(Foyer foyer) {
        foyerRepository.save(foyer);
        return foyer;
    }

    @Override
    public void delete(Foyer foyer) {
        foyerRepository.delete(foyer);
    }

    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversity) {
        // Vérifier si l'université existe
        University university = universityRepository.findById(idUniversity)
                .orElseThrow(() -> new RuntimeException("Université non trouvée avec l'ID : " + idUniversity));

        // Sauvegarder d'abord le foyer pour obtenir l'ID généré
        foyer = foyerRepository.save(foyer);



        // Créer des blocs séparément (Exemple, les blocs sont créés et associés après)
        Set<Bloc> blocs = new HashSet<>();
        // Ajouter des blocs créés séparément à la collection de blocs
        Bloc bloc1 = new Bloc();
        bloc1.setNom("Bloc A");
        bloc1.setCapacityBloc(100);
        bloc1.setFoyer(foyer);  // Associer le bloc au foyer
        blocs.add(bloc1);

        Bloc bloc2 = new Bloc();
        bloc2.setNom("Bloc B");
        bloc2.setCapacityBloc(150);
        bloc2.setFoyer(foyer);  // Associer le bloc au foyer
        blocs.add(bloc2);

        // Ajouter les blocs créés à la collection du foyer
        foyer.setBlocs(blocs);

        // Sauvegarder les blocs dans la base de données
        blocRepository.saveAll(blocs);

        // Sauvegarder le foyer avec les blocs associés
        foyer = foyerRepository.save(foyer);

        // Lier le foyer à l'université
        university.setFoyer(foyer);

        // Sauvegarder l'université après l'association du foyer
        universityRepository.save(university);

        // Retourner le foyer
        return foyer;
    }

}
