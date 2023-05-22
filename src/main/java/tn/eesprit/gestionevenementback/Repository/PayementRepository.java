package tn.eesprit.gestionevenementback.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.eesprit.gestionevenementback.Entities.Payement;
import tn.eesprit.gestionevenementback.Entities.Payement;

import java.util.List;

public interface PayementRepository extends JpaRepository<Payement, Integer> {

}