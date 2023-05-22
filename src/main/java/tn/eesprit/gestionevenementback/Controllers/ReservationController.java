package tn.eesprit.gestionevenementback.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.eesprit.gestionevenementback.Entities.Reservation;
import tn.eesprit.gestionevenementback.Services.IReservationService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reservation")
public class ReservationController {
    private final IReservationService reservationService;
    @PostMapping("/add")
    Reservation addReservation(@RequestBody Reservation reservation)
    {
        return reservationService.addOrUpdateReservation(reservation);
    }
    @PutMapping("/update")
    Reservation updateReservation(@RequestBody Reservation reservation){
        return reservationService.addOrUpdateReservation(reservation);
    }
    @GetMapping("/get/{id}")
    Reservation getReservation(@PathVariable("id") Integer id){
        return reservationService.retrieveReservation(id);
    }
    @GetMapping("/all")
    List<Reservation> getAllReservations(){return reservationService.retrieveAllReservations();}
    @DeleteMapping("/delete/{id}")
    void deleteReservation(@PathVariable("id") Integer id){
        reservationService.removeReservation(id);
    }

}
