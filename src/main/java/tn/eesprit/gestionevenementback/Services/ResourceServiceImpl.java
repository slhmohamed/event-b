package tn.eesprit.gestionevenementback.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.eesprit.gestionevenementback.Entities.ResourceMateriel;
import tn.eesprit.gestionevenementback.Repository.ResourceMaterielRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResourceServiceImpl implements IResourceService{
    private final ResourceMaterielRepository ResourceRepo;
    @Override
    public List<ResourceMateriel> retrieveAllResourcesMateriels(){return ResourceRepo.findAll();}
    @Override
    public ResourceMateriel addOrUpdateResourceMateriel(ResourceMateriel Resource){return ResourceRepo.save(Resource);}
    @Override
    public ResourceMateriel retrieveResourceMateriel(Integer id){return ResourceRepo.findById(id).orElse(null);}
    @Override
    public void removeResourceMateriel(Integer id){ResourceRepo.deleteById(id);}

}
