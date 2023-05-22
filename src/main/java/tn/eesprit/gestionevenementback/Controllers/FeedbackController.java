package tn.eesprit.gestionevenementback.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.eesprit.gestionevenementback.Entities.Feedback;
import tn.eesprit.gestionevenementback.Services.IFeedbackService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/feedback")
public class FeedbackController {
    private final IFeedbackService feedbackService;
    @PostMapping("/add")
    Feedback addFeedback(@RequestBody Feedback feedback)
    {
        return feedbackService.addOrUpdateFeedback(feedback);
    }
    @PutMapping("/update")
    Feedback updateFeedback(@RequestBody Feedback feedback){
        return feedbackService.addOrUpdateFeedback(feedback);
    }
    @GetMapping("/get/{id}")
    Feedback getFeedback(@PathVariable("id") Integer id){
        return feedbackService.retrieveFeedback(id);
    }
    @GetMapping("/all")
    List<Feedback> getAllFeedbacks(){return feedbackService.retrieveAllFeedbacks();}
    @DeleteMapping("/delete/{id}")
    void deleteFeedback(@PathVariable("id") Integer id){
        feedbackService.removeFeedback(id);
    }

}
