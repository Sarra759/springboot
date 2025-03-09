package com.example.tp1.controlleurs;

import com.example.tp1.entities.Bloc;
import com.example.tp1.entities.Chambre;
import com.example.tp1.entities.services.IBlocService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/bloc")
public class BlocControlleur {

    IBlocService blocService;

    @GetMapping("/retrieve-all-blocs")
    public List<Bloc> getBlocs() {
        return blocService.retrieveBlocs();
    }

    @GetMapping("/retrieve-bloc/{bloc-id}")
    public Bloc retrieveBloc(@PathVariable("bloc-id") Long bId) {
        return blocService.retrieveBloc(bId);
    }

    @PostMapping("/add-bloc")
    public Bloc addBloc(@RequestBody Bloc b) {
        return blocService.addBloc(b);
    }
  @PutMapping("/update")
  public Bloc updateBloc(@RequestBody Bloc b) {
        return blocService.updateBloc(b);
  }
    @DeleteMapping("/remove-bloc/{bloc-id}")
    public void removeBloc(@PathVariable("bloc-id") Long bId) {
        blocService.removeBloc(bId);
    }
    @PostMapping("/affectationchambrea/{idbloc}/{listChambre}")
    public Bloc affectationChambrea(@PathVariable Long idbloc, @PathVariable List<Long> listChambre) {
        return blocService.affecterChambresABloc(listChambre, idbloc);
    }

}
