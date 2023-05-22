package tn.eesprit.gestionevenementback.Services;

import tn.eesprit.gestionevenementback.Entities.Forum;

import java.util.List;

public interface IForumService {
    List<Forum> retrieveAllForums();
    Forum addOrUpdateForum(Forum Forum);
    Forum retrieveForum(Integer id);
    void removeForum(Integer id);
}
