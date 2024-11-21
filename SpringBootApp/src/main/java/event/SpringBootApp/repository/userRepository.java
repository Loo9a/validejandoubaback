package event.SpringBootApp.repository;

import event.SpringBootApp.Entities.userEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface userRepository extends CrudRepository<userEntity,Integer> {

    Optional<userEntity> findByEmail(String email);
}
