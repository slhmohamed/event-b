package tn.eesprit.gestionevenementback.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.eesprit.gestionevenementback.Entities.Logistique;
import tn.eesprit.gestionevenementback.Repository.LogistiqueRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LogistiqueServiceImpl implements ILogistiqueService{
    private final LogistiqueRepository LogistiqueRepo;
    @Override
    public List<Logistique> retrieveAllLogistiques(){return LogistiqueRepo.findAll();}
    @Override
    public Logistique addOrUpdateLogistique(Logistique logistique){return LogistiqueRepo.save(logistique);}
    @Override
    public Logistique retrieveLogistique(Integer id){return LogistiqueRepo.findById(id).orElse(null);}
    @Override
    public void removeLogistique(Integer id){LogistiqueRepo.deleteById(id);}

}
