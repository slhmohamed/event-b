package tn.eesprit.gestionevenementback.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.eesprit.gestionevenementback.Entities.ServiceClient;
import tn.eesprit.gestionevenementback.Repository.ServiceClientRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceClientServiceImpl implements IServiceClientService {
    private final ServiceClientRepository ServiceRepo;
    @Override
    public List<ServiceClient> retrieveAllServices(){return ServiceRepo.findAll();}
    @Override
    public ServiceClient addOrUpdateService(ServiceClient service){return ServiceRepo.save(service);}
    @Override
    public ServiceClient retrieveService(Integer id){return ServiceRepo.findById(id).orElse(null);}
    @Override
    public void removeService(Integer id){ServiceRepo.deleteById(id);}

}
