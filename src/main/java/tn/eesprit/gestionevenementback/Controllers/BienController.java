package tn.eesprit.gestionevenementback.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.eesprit.gestionevenementback.Entities.Bien;
import tn.eesprit.gestionevenementback.Services.IBienService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bien")
public class BienController {
    private final IBienService bienService;
    @PostMapping("/add")
    Bien addBien(@RequestBody Bien bien)
    {
        return bienService.addOrUpdateBien(bien);
    }
    @PutMapping("/update")
    Bien updateBien(@RequestBody Bien bien){
        return bienService.addOrUpdateBien(bien);
    }
    @GetMapping("/get/{id}")
    Bien getBien(@PathVariable("id") Integer id){
        return bienService.retrieveBien(id);
    }
    @GetMapping("/all")
    List<Bien> getAllBiens(){return bienService.retrieveAllBiens();}
    @DeleteMapping("/delete/{id}")
    void deleteBien(@PathVariable("id") Integer id){
        bienService.removeBien(id);
    }

}
