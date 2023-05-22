package tn.eesprit.gestionevenementback.Services;

import tn.eesprit.gestionevenementback.Entities.User;

import java.util.List;

public interface IUserService {
    List<User> retrieveAllUsers();
    User addOrUpdateUser(User User);
    User retrieveUser(Long id);
    void removeUser(Long id);
}
