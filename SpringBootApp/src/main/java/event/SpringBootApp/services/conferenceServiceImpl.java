package event.SpringBootApp.services;

import event.SpringBootApp.Entities.conferenceEntity;
import event.SpringBootApp.repository.conferenceRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class conferenceServiceImpl implements conferenceService {

    @Autowired
    conferenceRepository CR;



    @Override
    public conferenceEntity addconference(conferenceEntity conference) {
        return CR.save(conference);
    }

    @Override
    public conferenceEntity updateconference(conferenceEntity conference, int idC) {


        conferenceEntity existingConference = CR.findById(idC)
                .orElseThrow(() -> new EntityNotFoundException("conference not found with id: " + idC));


        existingConference.setDuree(conference.getDuree());
        existingConference.setTitre(conference.getTitre());
        existingConference.setHeure(conference.getHeure());



        return CR.save(existingConference);
    }

    @Override
    public void deleteconference(int idC) {

    }

    @Override
    public List<conferenceEntity> getALL() {
        return null;
    }
}