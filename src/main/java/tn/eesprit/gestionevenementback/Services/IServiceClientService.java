package tn.eesprit.gestionevenementback.Services;

import tn.eesprit.gestionevenementback.Entities.ServiceClient;

import java.util.List;

public interface IServiceClientService {
    List<ServiceClient> retrieveAllServices();
    ServiceClient addOrUpdateService(ServiceClient ServiceClient);
    ServiceClient retrieveService(Integer id);
    void removeService(Integer id);
}
