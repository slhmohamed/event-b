package tn.eesprit.gestionevenementback.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.eesprit.gestionevenementback.Entities.Event;
import tn.eesprit.gestionevenementback.Repository.EventRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements IEventService{
    private final EventRepository EventRepo;
    @Override
    public List<Event> retrieveAllEvents(){return EventRepo.findAll();}

    @Override
    public Event addEvent(Event event) {
        return EventRepo.save(event);
    }


    @Override
    public void  deleteEvent (Long id){
        EventRepo.deleteById(id);
    }

}
