package tn.eesprit.gestionevenementback.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.eesprit.gestionevenementback.Entities.Event;
import tn.eesprit.gestionevenementback.Exception.ResourceNotFoundException;
import tn.eesprit.gestionevenementback.Repository.EventRepository;
import tn.eesprit.gestionevenementback.Services.IEventService;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/event")
public class EventController {
    private final IEventService eventService;
    private final EventRepository eventRepository;
    @PostMapping("/add-events")
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        Event _event = eventService.addEvent(new Event(
                event.getTitle(), event.getDescription(),event.getStartDate(),event.getEndDate(),event.getLieu(),event.getType()));
        return new ResponseEntity<>(_event, HttpStatus.CREATED);
    }
@GetMapping("/get-event/{id}")
public ResponseEntity<Event> getEvent(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
    Event event = eventRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Not found user with id = " + id));
    return new ResponseEntity<>(event, HttpStatus.OK);

    }


    @GetMapping("/all-events")
    public ResponseEntity<List<Event>> getAllEvents(){
       return  new ResponseEntity<>( eventService.retrieveAllEvents(), HttpStatus.OK);
    }
    @DeleteMapping("/delete-event/{id}")
    public ResponseEntity<HttpStatus> deleteEvent(@PathVariable("id") long id) {
        eventService.deleteEvent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping ("/update-event/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable(value = "id") Long id,@RequestBody Event event) throws ResourceNotFoundException {
        Event _event = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found user with id = " + id));

        _event.setTitle(event.getTitle());
        _event.setLieu(event.getLieu());
        _event.setEndDate(event.getEndDate());
        _event.setStartDate(event.getStartDate());
        _event.setDescription(event.getDescription());
        _event.setType(event.getType());
        eventRepository.save(_event);

        return new ResponseEntity<>(_event, HttpStatus.OK);

    }

    @GetMapping("/event-by-type")
    public ResponseEntity< List<Object[]>> getEventByType(){
        List<Object[]> list=eventRepository.countTotalEventsByType();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
