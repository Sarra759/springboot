package com.example.tp1.entities.services;

import com.example.tp1.entities.Bloc;
import com.example.tp1.entities.Chambre;
import com.example.tp1.repositories.IBlocRepository;
import com.example.tp1.repositories.IChambreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class IblocServiceImpl implements IBlocService {
    IBlocRepository repo;
    IChambreRepository chambreRepo;
    @Override
    public List<Bloc> retrieveBlocs() {
        return (List<Bloc>)repo.findAll();
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return repo.save(bloc);
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return repo.save(bloc);
    }

    @Override
    public Bloc retrieveBloc(long idBloc) {
        return repo.findById(idBloc).get();
    }

    @Override
    public void removeBloc(long idBloc) {
        repo.deleteById(idBloc);
    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {
        List<Chambre> chambres = chambreRepo.findByNumchambreIn(numChambre);  // Méthode adaptée pour récupérer les chambres par leurs numéros

        // Vérifiez que les chambres sont bien récupérées
        if (chambres.isEmpty()) {
            throw new IllegalArgumentException("Aucune chambre trouvée avec les numéros spécifiés");
        }

        // Récupérer le bloc
        Bloc bloc = repo.findById(idBloc).orElseThrow(() -> new IllegalArgumentException("Bloc non trouvé"));

        // Affecter chaque chambre au bloc
        chambres.forEach(chambre -> {
            chambre.setBloc(bloc);
        });

        // Sauvegarder toutes les chambres en une seule opération
        chambreRepo.saveAll(chambres);

        return bloc;
    }
}
