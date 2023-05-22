package tn.eesprit.gestionevenementback.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.eesprit.gestionevenementback.Entities.Post;
import tn.eesprit.gestionevenementback.Entities.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

}