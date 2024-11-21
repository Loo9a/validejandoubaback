package event.SpringBootApp.services;

import event.SpringBootApp.Entities.eventEntity;

import java.util.List;

public interface eventService {
    eventEntity addevent(eventEntity event);

    eventEntity updateevent(eventEntity event, int idE);

    void deleteevent(int idE);

    List<eventEntity> getALL();
}