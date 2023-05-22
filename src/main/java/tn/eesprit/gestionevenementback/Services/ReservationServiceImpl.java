package tn.eesprit.gestionevenementback.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.eesprit.gestionevenementback.Entities.Reservation;
import tn.eesprit.gestionevenementback.Repository.ReservationRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements IReservationService{
    private final ReservationRepository ReservationRepo;
    @Override
    public List<Reservation> retrieveAllReservations(){return ReservationRepo.findAll();}
    @Override
    public Reservation addOrUpdateReservation(Reservation reservation){return ReservationRepo.save(reservation);}
    @Override
    public Reservation retrieveReservation(Integer id){return ReservationRepo.findById(id).orElse(null);}
    @Override
    public void removeReservation(Integer id){ReservationRepo.deleteById(id);}

}
