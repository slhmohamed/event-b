package tn.eesprit.gestionevenementback.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.eesprit.gestionevenementback.Entities.Bien;
import tn.eesprit.gestionevenementback.Repository.BienRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BienServiceImpl implements IBienService{
    private final BienRepository BienRepo;
    @Override
    public List<Bien> retrieveAllBiens(){return BienRepo.findAll();}
    @Override
    public Bien addOrUpdateBien(Bien bien){return BienRepo.save(bien);}
    @Override
    public Bien retrieveBien(Integer id){return BienRepo.findById(id).orElse(null);}
    @Override
    public void removeBien(Integer id){BienRepo.deleteById(id);}

}
