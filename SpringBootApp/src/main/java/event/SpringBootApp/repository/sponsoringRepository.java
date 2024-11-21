package event.SpringBootApp.repository;

import event.SpringBootApp.Entities.sponsoringEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface sponsoringRepository extends CrudRepository<sponsoringEntity,Integer> {


}
