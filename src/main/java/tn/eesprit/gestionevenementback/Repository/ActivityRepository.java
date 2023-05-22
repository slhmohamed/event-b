package tn.eesprit.gestionevenementback.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.eesprit.gestionevenementback.Entities.Activity;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {

}