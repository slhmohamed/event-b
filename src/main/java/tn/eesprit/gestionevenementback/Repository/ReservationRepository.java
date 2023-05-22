package tn.eesprit.gestionevenementback.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.eesprit.gestionevenementback.Entities.Reservation;
import tn.eesprit.gestionevenementback.Entities.Reservation;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}