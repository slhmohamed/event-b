package tn.eesprit.gestionevenementback.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.eesprit.gestionevenementback.Entities.Activity;
import tn.eesprit.gestionevenementback.Repository.ActivityRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityServiceImpl implements IActivityService{
    private final ActivityRepository activityRepo;
    @Override
    public List<Activity> retrieveAllActivities(){return activityRepo.findAll();};
    @Override
    public Activity addOrUpdateActivity(Activity activity){return activityRepo.save(activity);};
    @Override
    public Activity retrieveActivity(Integer id){return activityRepo.findById(id).orElse(null);};
    @Override
    public void removeActivity(Integer id){activityRepo.deleteById(id);};

}
