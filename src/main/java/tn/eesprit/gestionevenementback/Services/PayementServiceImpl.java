package tn.eesprit.gestionevenementback.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.eesprit.gestionevenementback.Entities.Payement;
import tn.eesprit.gestionevenementback.Repository.PayementRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PayementServiceImpl implements IPayementService{
    private final PayementRepository PayementRepo;
    @Override
    public List<Payement> retrieveAllPayements(){return PayementRepo.findAll();}
    @Override
    public Payement addOrUpdatePayement(Payement payement){return PayementRepo.save(payement);}
    @Override
    public Payement retrievePayement(Integer id){return PayementRepo.findById(id).orElse(null);}
    @Override
    public void removePayement(Integer id){PayementRepo.deleteById(id);}

}
