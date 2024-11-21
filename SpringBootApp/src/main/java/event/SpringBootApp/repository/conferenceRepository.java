package event.SpringBootApp.repository;

import event.SpringBootApp.Entities.conferenceEntity;
import event.SpringBootApp.Entities.eventEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface conferenceRepository extends CrudRepository<conferenceEntity,Integer> {

    conferenceEntity save(conferenceEntity conference);
}
