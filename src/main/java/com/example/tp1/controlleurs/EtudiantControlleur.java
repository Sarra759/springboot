package com.example.tp1.controlleurs;

import com.example.tp1.entities.Etudiant;
import com.example.tp1.entities.services.IEtudiantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiant")
@AllArgsConstructor
public class EtudiantControlleur {
    IEtudiantService etudiantService;
    @PostMapping("/addetudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant e) {
        Etudiant etudiant = etudiantService.addEtudiant(e);
        return etudiant;
    }
    @GetMapping ("/getall")
    public List<Etudiant> getEtudiants() {
        List<Etudiant> listEtudiants = etudiantService.retrieveAllEtudiants();
        return listEtudiants;
    }

    @PutMapping("/updateetudiant")
    public Etudiant modifyEtudiant(@RequestBody Etudiant e) {
        Etudiant etudiant = etudiantService.updateEtudiant(e);
        return etudiant;
    }
    @DeleteMapping("/delete/{id}")
    public void deleteEtudiant(@PathVariable long id) {
        etudiantService.removeEtudiant(id);
    }


    @GetMapping("/retrieveEtudiant/{id}")
    public Etudiant retrieveEtudiantById(@PathVariable("id") long id) {
        return etudiantService.retrieveEtudiant(id);
    }


}
