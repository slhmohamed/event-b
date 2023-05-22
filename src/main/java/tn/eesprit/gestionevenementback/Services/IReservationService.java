package tn.eesprit.gestionevenementback.Services;

import tn.eesprit.gestionevenementback.Entities.Reservation;

import java.util.List;

public interface IReservationService {
    List<Reservation> retrieveAllReservations();
    Reservation addOrUpdateReservation(Reservation Reservation);
    Reservation retrieveReservation(Integer id);
    void removeReservation(Integer id);
}
