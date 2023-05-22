package tn.eesprit.gestionevenementback.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.eesprit.gestionevenementback.Entities.User;
import tn.eesprit.gestionevenementback.Repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService{
    private final UserRepository UserRepo;
    @Override
    public List<User> retrieveAllUsers(){return UserRepo.findAll();}
    @Override
    public User addOrUpdateUser(User user){return UserRepo.save(user);}
    @Override
    public User retrieveUser(Long id){return UserRepo.findById(id).orElse(null);}
    @Override
    public void removeUser(Long id){UserRepo.deleteById(id);}

}

