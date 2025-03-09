package com.example.tp1.controlleurs;

import com.example.tp1.entities.University;
import com.example.tp1.entities.services.IUniversityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/university")
@RestController
@AllArgsConstructor
public class UniversityControlleur {
    IUniversityService universityService;
    @GetMapping("/retrieveAllUniversities")
    public List<University> retrieveAllUniversities() {
        return universityService.retrieveAllUniversities();
    }
    @PostMapping("/addUniversite")
    public University addUniversity(@RequestBody University university) {
        return universityService.addUniversite(university);
    }
    @PutMapping("/updateUniversite")
    public University updateUniversity(@RequestBody University university) {
        return universityService.updateUniversite(university);
    }
    @GetMapping("/retrieveUniversite/{id}")

    public University retrieveUniversity(@PathVariable int id) {
        return universityService.retrieveUniversite(id);
    }
    @PostMapping("/affecterFoyerAUniversite/{universityName}/{idfoyer}")
    public University affecterFoyerAUniversite( @PathVariable long idfoyer, @PathVariable String universityName) {
        return universityService.affecterFoyerAUniversite(idfoyer,universityName);
    }
    @PostMapping("/desaffecterFoyerAUniversite/{id}")
    public University desaffecterFoyerAUniversite(@PathVariable long id) {
        return universityService.desaffecterFoyerAUniversite(id);
    }



}
