package tn.eesprit.gestionevenementback.Services;

import tn.eesprit.gestionevenementback.Entities.Bien;

import java.util.List;

public interface IBienService {
    List<Bien> retrieveAllBiens();
    Bien addOrUpdateBien(Bien Bien);
    Bien retrieveBien(Integer id);
    void removeBien(Integer id);
}
