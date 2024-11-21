package event.SpringBootApp.services;

import event.SpringBootApp.Entities.eventEntity;
import event.SpringBootApp.repository.eventRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class eventServiceImpl implements eventService {

    @Autowired
    eventRepository eR;

    @Override
    public eventEntity addevent(eventEntity event) {

        return eR.save(event);
    }

    @Override
    public eventEntity updateevent(eventEntity event, int idE) {
        eventEntity existingEvent = eR.findById(idE)
                .orElseThrow(() -> new EntityNotFoundException("event not found with id: " + idE));


        existingEvent.setNom(event.getNom());
        existingEvent.setLieu(event.getLieu());
        existingEvent.setDate(event.getDate());



        return eR.save(existingEvent);

    }

    @Override
    public void deleteevent(int idE) {

    }

    @Override
    public List<eventEntity> getALL() {
        return null;
    }

}