package com.events.eventmanagement.Repository;

import com.events.eventmanagement.Models.EventModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventsRepository extends JpaRepository<EventModel,Integer> {

}
