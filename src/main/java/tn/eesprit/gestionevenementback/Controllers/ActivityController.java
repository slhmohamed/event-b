package tn.eesprit.gestionevenementback.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.eesprit.gestionevenementback.Entities.Activity;
import tn.eesprit.gestionevenementback.Services.IActivityService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/activity")
public class ActivityController {
    private final IActivityService activityService;
    @PostMapping("/add")
    Activity addActivity(@RequestBody Activity activity)
    {
        return activityService.addOrUpdateActivity(activity);
    }
    @PutMapping("/update")
    Activity updateActivity(@RequestBody Activity activity){
        return activityService.addOrUpdateActivity(activity);
    }
    @GetMapping("/get/{id}")
    Activity getActivity(@PathVariable("id") Integer id){
        return activityService.retrieveActivity(id);
    }
    @GetMapping("/all")
    List<Activity> getAllActivitys(){return activityService.retrieveAllActivities();}
    @DeleteMapping("/delete/{id}")
    void deleteActivity(@PathVariable("id") Integer id){
        activityService.removeActivity(id);
    }

}
