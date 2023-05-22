package tn.eesprit.gestionevenementback.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.eesprit.gestionevenementback.Entities.Feedback;
import tn.eesprit.gestionevenementback.Repository.FeedbackRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedbackServiceImpl implements IFeedbackService{
    private final FeedbackRepository feedbackRepo;
    @Override
    public List<Feedback> retrieveAllFeedbacks(){return feedbackRepo.findAll();}
    @Override
    public Feedback addOrUpdateFeedback(Feedback feedback){return feedbackRepo.save(feedback);}
    @Override
    public Feedback retrieveFeedback(Integer id){return feedbackRepo.findById(id).orElse(null);}
    @Override
    public void removeFeedback(Integer id){feedbackRepo.deleteById(id);}

}
