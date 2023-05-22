package tn.eesprit.gestionevenementback.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.eesprit.gestionevenementback.Entities.Payement;
import tn.eesprit.gestionevenementback.Services.IPayementService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payement")
public class PayementController {
    private final IPayementService payementService;
    @PostMapping("/add")
    Payement addPayement(@RequestBody Payement payement)
    {
        return payementService.addOrUpdatePayement(payement);
    }
    @PutMapping("/update")
    Payement updatePayement(@RequestBody Payement payement){
        return payementService.addOrUpdatePayement(payement);
    }
    @GetMapping("/get/{id}")
    Payement getPayement(@PathVariable("id") Integer id){
        return payementService.retrievePayement(id);
    }
    @GetMapping("/all")
    List<Payement> getAllPayements(){return payementService.retrieveAllPayements();}
    @DeleteMapping("/delete/{id}")
    void deletePayement(@PathVariable("id") Integer id){
        payementService.removePayement(id);
    }

}
