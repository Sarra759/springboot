package com.example.tp1.controlleurs;

import com.example.tp1.entities.Foyer;
import com.example.tp1.entities.services.IFoyerServices;
import com.example.tp1.entities.services.IfoyerServicesImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foyer")
@AllArgsConstructor
public class FoyerControlleur {
    IFoyerServices foyerService;

    @PostMapping("/saveFoyer")
    public Foyer saveFoyer(@RequestBody Foyer foyer) {
        return foyerService.save(foyer);
    }

    @GetMapping("/getByid/{id}")
    public Foyer getFoyer(@PathVariable int id) {
        return foyerService.findByid(id);
    }

    /*@GetMapping("/getByNomCapacite/{nom}/{capacite}")
    public Foyer getFoyerCapacite(@PathVariable String nom, @PathVariable long capacite) {
        return foyerService.getNomCapacite(nom, capacite);
    }*/
    @GetMapping("/findAll")
    public List<Foyer> findAll() {
        return foyerService.findAll();
    }

    @DeleteMapping("/delete")
    public void deleteFoyer(@RequestBody Foyer foyer) {
        foyerService.delete(foyer);
    }

    @PostMapping("/ajouterfoyeretaffectation/{iduniversity}")
    public Foyer ajouterFoyerEtAffecterAUniversite(@RequestBody Foyer foyer, @PathVariable long iduniversity) {
        return foyerService.ajouterFoyerEtAffecterAUniversite(foyer, iduniversity);
    }

}