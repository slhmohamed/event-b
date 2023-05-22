package tn.eesprit.gestionevenementback.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.eesprit.gestionevenementback.Entities.Facture;
import tn.eesprit.gestionevenementback.Repository.FactureRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FactureServiceImpl implements IFactureService{
    private final FactureRepository FactureRepo;
    @Override
    public List<Facture> retrieveAllFactures(){return FactureRepo.findAll();}
    @Override
    public Facture addOrUpdateFacture(Facture facture){return FactureRepo.save(facture);}
    @Override
    public Facture retrieveFacture(Long id){return FactureRepo.findById(id).orElse(null);}
    @Override
    public void removeFacture(Long id){FactureRepo.deleteById(id);}

}
