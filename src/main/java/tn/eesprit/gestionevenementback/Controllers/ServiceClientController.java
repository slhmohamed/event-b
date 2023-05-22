package tn.eesprit.gestionevenementback.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.eesprit.gestionevenementback.Entities.ServiceClient;
import tn.eesprit.gestionevenementback.Services.IServiceClientService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/service")
public class ServiceClientController {
    private final IServiceClientService serviceClientService;
    @PostMapping("/add")
    ServiceClient addServiceClient(@RequestBody ServiceClient serviceClient)
    {
        return serviceClientService.addOrUpdateService(serviceClient);
    }
    @PutMapping("/update")
    ServiceClient updateServiceClient(@RequestBody ServiceClient serviceClient){
        return serviceClientService.addOrUpdateService(serviceClient);
    }
    @GetMapping("/get/{id}")
    ServiceClient getServiceClient(@PathVariable("id") Integer id){
        return serviceClientService.retrieveService(id);
    }
    @GetMapping("/all")
    List<ServiceClient> getAllServiceClients(){return serviceClientService.retrieveAllServices();}
    @DeleteMapping("/delete/{id}")
    void deleteServiceClient(@PathVariable("id") Integer id){
        serviceClientService.removeService(id);
    }

}
