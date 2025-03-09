package com.example.tp1.controlleurs;

import com.example.tp1.entities.Chambre;
import com.example.tp1.entities.TypeChambre;
import com.example.tp1.entities.services.IChambreService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/chambre")
public class ChambreControlleur {
    IChambreService chambreService;

    @PostMapping("/addchambre")
    public Chambre addChambre(@RequestBody Chambre chambre) {
        return chambreService.addChambre(chambre);
    }

    @PutMapping("/updatechambre")
    public Chambre updateChambre(@RequestBody Chambre chambre) {
        return chambreService.updateChambre(chambre);
    }

    @GetMapping("/retrieveChambre/{id}")
    public Chambre retrieveChambre(@PathVariable int id) {
        return chambreService.retrieveChambre(id);
    }

    @GetMapping("/getallchambre")
    public List<Chambre> getAllChambre() {
        return chambreService.retrieveAllChambres();
    }

    @GetMapping("/universite/{universityName}")
    public List<Chambre> getChambresParNomUniversite(@PathVariable String universityName) {

        return chambreService.getChambresParNomUniversite(universityName);

    }
    @GetMapping("/par-bloc-et-type")
    public List<Chambre> getChambresParBlocEtType(@RequestParam long idBloc, @RequestParam TypeChambre typeChambre) {
        return chambreService.getChambresParBlocEtType(idBloc, typeChambre);
    }

}
