package com.events.eventmanagement.Controllers;

import com.events.eventmanagement.Models.EventModel;
import com.events.eventmanagement.Services.EventServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/events")
public class EventsController {

    @Autowired
    private EventServices eventServices;
    @PostMapping("/addEvent")
    public ResponseEntity<EventModel> addEvent(@RequestBody EventModel event) {
        EventModel saved= eventServices.addEvent(event);
         return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/getAllEvents")
    public ResponseEntity<List<EventModel>> getAllUsers(){
        List<EventModel> events = eventServices.getAllUsers();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @DeleteMapping("deleteEvent/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable("id") int eventId){
        eventServices.deleteEvent(eventId);
        return new ResponseEntity<>("Event successfully deleted!", HttpStatus.OK);
    }

    @GetMapping("getEventById/{id}")
    public ResponseEntity<EventModel> getUserById(@PathVariable("id") int eventId){
        EventModel event = eventServices.getEventById(eventId);
        return new ResponseEntity<>(event, HttpStatus.OK);
    }

    @PutMapping("updateEvent/{id}")
    public ResponseEntity<EventModel> updateUser(@PathVariable("id") int eventId,
                                           @RequestBody EventModel event){
        EventModel updatedEvent = eventServices.updateEvent(event,eventId);
        return new ResponseEntity<>(updatedEvent, HttpStatus.OK);
    }
}
