package tn.eesprit.gestionevenementback.Services;

import tn.eesprit.gestionevenementback.Entities.ResourceMateriel;

import java.util.List;

public interface IResourceService {
    List<ResourceMateriel> retrieveAllResourcesMateriels();
    ResourceMateriel addOrUpdateResourceMateriel(ResourceMateriel ResourceMateriel);
    ResourceMateriel retrieveResourceMateriel(Integer id);
    void removeResourceMateriel(Integer id);
}
