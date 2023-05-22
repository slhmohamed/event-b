package tn.eesprit.gestionevenementback.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.eesprit.gestionevenementback.Entities.ResourceMateriel;
import tn.eesprit.gestionevenementback.Services.IResourceService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/resource")
public class ResourceController {
    private final IResourceService resourceMaterielService;
    @PostMapping("/add")
    ResourceMateriel addResourceMateriel(@RequestBody ResourceMateriel resource)
    {
        return resourceMaterielService.addOrUpdateResourceMateriel(resource);
    }
    @PutMapping("/update")
    ResourceMateriel updateResourceMateriel(@RequestBody ResourceMateriel resource){
        return resourceMaterielService.addOrUpdateResourceMateriel(resource);
    }
    @GetMapping("/get/{id}")
    ResourceMateriel getResourceMateriel(@PathVariable("id") Integer id){
        return resourceMaterielService.retrieveResourceMateriel(id);
    }
    @GetMapping("/all")
    List<ResourceMateriel> getAllResourceMateriels(){return resourceMaterielService.retrieveAllResourcesMateriels();}
    @DeleteMapping("/delete/{id}")
    void deleteResourceMateriel(@PathVariable("id") Integer id){
        resourceMaterielService.removeResourceMateriel(id);
    }

}
