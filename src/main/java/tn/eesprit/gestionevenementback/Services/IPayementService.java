package tn.eesprit.gestionevenementback.Services;

import tn.eesprit.gestionevenementback.Entities.Payement;

import java.util.List;

public interface IPayementService {
    List<Payement> retrieveAllPayements();
    Payement addOrUpdatePayement(Payement Payement);
    Payement retrievePayement(Integer id);
    void removePayement(Integer id);
}
