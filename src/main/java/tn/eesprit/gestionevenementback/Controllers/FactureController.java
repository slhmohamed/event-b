package tn.eesprit.gestionevenementback.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.eesprit.gestionevenementback.Entities.Facture;
import tn.eesprit.gestionevenementback.Entities.User;
import tn.eesprit.gestionevenementback.Exception.ResourceNotFoundException;
import tn.eesprit.gestionevenementback.Repository.FactureRepository;
import tn.eesprit.gestionevenementback.Repository.UserRepository;
import tn.eesprit.gestionevenementback.Services.IFactureService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/facture")
@CrossOrigin(origins = "*", maxAge = 3600)

public class FactureController {
    private final IFactureService factureService;
    private final UserRepository userRepository;
    private final FactureRepository factureRepository;
    @GetMapping("/users/{id}/factures")
    public ResponseEntity<List<Facture>> getAllFactureByUserid(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found user with id = " + id));

        List<Facture> factures = new ArrayList<Facture>();
        factures.addAll(user.getFactures());

        return new ResponseEntity<>(factures, HttpStatus.OK);
    }
    @PostMapping("/users/{id}/facture")
    public ResponseEntity<Facture> creatReclamation(@PathVariable(value = "id") Long id,
                                                        @RequestBody Facture facture) throws ResourceNotFoundException {
        Facture _facture = userRepository.findById(id).map((User user) -> {
            user.getFactures().add(facture);
            return factureRepository.save(facture);
        }).orElseThrow(() -> new ResourceNotFoundException("Not found User with id = " + id));

        return new ResponseEntity<>(_facture, HttpStatus.CREATED);
    }

}
