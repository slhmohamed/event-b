package tn.eesprit.gestionevenementback.Services;

import tn.eesprit.gestionevenementback.Entities.Feedback;

import java.util.List;

public interface IFeedbackService {
    List<Feedback> retrieveAllFeedbacks();
    Feedback addOrUpdateFeedback(Feedback Feedback);
    Feedback retrieveFeedback(Integer id);
    void removeFeedback(Integer id);
}
