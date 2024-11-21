package event.SpringBootApp.repository;

import event.SpringBootApp.Entities.eventEntity;
import event.SpringBootApp.Entities.userEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface eventRepository extends CrudRepository<eventEntity,Integer> {



    eventEntity save(eventEntity event);
}
