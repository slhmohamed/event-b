package tn.eesprit.gestionevenementback.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.eesprit.gestionevenementback.Entities.Forum;
import tn.eesprit.gestionevenementback.Entities.Forum;

import java.util.List;

public interface ForumRepository extends JpaRepository<Forum, Integer> {

}