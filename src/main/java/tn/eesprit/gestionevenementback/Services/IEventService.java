package tn.eesprit.gestionevenementback.Services;

import tn.eesprit.gestionevenementback.Entities.Event;

import java.util.List;

public interface IEventService {
    List<Event> retrieveAllEvents();
    Event addEvent(Event event);

    public void  deleteEvent (Long id);
}
