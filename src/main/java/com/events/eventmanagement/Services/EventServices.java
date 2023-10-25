package com.events.eventmanagement.Services;

import lombok.AllArgsConstructor;
import com.events.eventmanagement.Models.EventModel;
import com.events.eventmanagement.Repository.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServices {
    @Autowired
    private EventsRepository eventsRepository;

    public EventModel addEvent(EventModel event) {
        return eventsRepository.save(event);
    }

    public List<EventModel> getAllUsers() {
        return eventsRepository.findAll();
    }

    public void deleteEvent(int eventId) {
        eventsRepository.deleteById(eventId);
    }

//    public EventModel getEventById(Integer eventId) {
//        Optional<EventModel> optionalUser = userRepository.findById(userId);
//        return optionalUser.get();
//    }

    public void deleteEvent(Integer eventId) {
        eventsRepository.deleteById(eventId);
    }

    public EventModel getEventById(int eventId) {
        return eventsRepository.findById(eventId).get();
    }

    public EventModel updateEvent(EventModel event, int eventId) {
        EventModel existingEvent = eventsRepository.findById(eventId).get();
        existingEvent.setEventName(event.getEventName());
        existingEvent.setEventDetails(event.getEventDetails());
        existingEvent.setEventDate(event.getEventDate());
        existingEvent.setEventTicketPrice(event.getEventTicketPrice());
        EventModel updatedevent = eventsRepository.save(existingEvent);
        return updatedevent;
    }
}
