package tn.eesprit.gestionevenementback.Services;

import tn.eesprit.gestionevenementback.Entities.Activity;

import java.util.List;

public interface IActivityService {
    List<Activity> retrieveAllActivities();
    Activity addOrUpdateActivity(Activity activity);
    Activity retrieveActivity(Integer id);
    void removeActivity(Integer id);
}